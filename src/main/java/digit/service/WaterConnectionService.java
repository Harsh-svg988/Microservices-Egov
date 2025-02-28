package digit.service;

import org.egov.tracer.model.CustomException;
import org.springframework.util.CollectionUtils;

import digit.enrichment.WaterConnectionEnrichment;
import digit.kafka.Producer;
import digit.repository.WaterConnectionRepository;
import digit.validators.WaterConnectionValidator;
import digit.web.models.WaterConnection;
import digit.web.models.WaterConnectionCreateRequest;
import digit.web.models.WaterConnectionSearchCriteria;
import digit.web.models.WaterConnectionUpdateRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class WaterConnectionService {

    @Autowired
    private WaterConnectionValidator validator;

    @Autowired
    private WaterConnectionEnrichment enrichmentUtil;

    @Autowired
    private Producer producer;

    @Autowired
    private UserService userService;

    @Autowired
    private WaterConnectionRepository waterConnectionRepository;

    public WaterConnection createWaterConnection(WaterConnectionCreateRequest createRequest) {
        validator.validateWaterConnectionRequest(createRequest);

        enrichmentUtil.enrichWaterConnection(createRequest);

        userService.callUserService(createRequest);

        producer.push("save-bt-application", createRequest);

        return createRequest.getWaterConnection();
    }

    public List<WaterConnection> searchWaterConnections(WaterConnectionSearchCriteria searchCriteria) {
        List<WaterConnection> connections = waterConnectionRepository.getConnections(searchCriteria);

        if (CollectionUtils.isEmpty(connections)) {
            return new ArrayList<>();
        }

        return connections;
    }

    public WaterConnection updateWaterConnection(WaterConnectionUpdateRequest waterConnectionUpdateRequest) {
        WaterConnection existingWaterConnection = waterConnectionRepository.getConnections(
                WaterConnectionSearchCriteria.builder()
                        .applicationNo(waterConnectionUpdateRequest.getId())
                        .build())
                .stream().findFirst().orElse(null);

        if (existingWaterConnection == null) {
            throw new CustomException("EG_WC_NOT_FOUND",
                    "Water connection with ID " + waterConnectionUpdateRequest.getId() + " not found.");
        }
        existingWaterConnection.setId(waterConnectionUpdateRequest.getId());
        existingWaterConnection.setConnectionType(waterConnectionUpdateRequest.getConnectionType());
        existingWaterConnection.setAdditionalDetails(waterConnectionUpdateRequest.getAdditionalDetails());
        existingWaterConnection.setPropertyId(waterConnectionUpdateRequest.getPropertyId());

        producer.push("update-bt-application", waterConnectionUpdateRequest);

        return existingWaterConnection;

    }

}