package digit.web.controllers;

import digit.service.WaterConnectionService;
import digit.util.ResponseInfoFactory;
import digit.web.models.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiParam;
import org.egov.common.contract.response.ResponseInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import jakarta.validation.Valid;
import jakarta.servlet.http.HttpServletRequest;

import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("")
public class WcApiController {

    private final ObjectMapper objectMapper;
    private final HttpServletRequest request;
    private final WaterConnectionService waterConnectionService;

    @Autowired
    private ResponseInfoFactory responseInfoFactory;

    @Autowired
    public WcApiController(ObjectMapper objectMapper, HttpServletRequest request, WaterConnectionService waterConnectionService) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.waterConnectionService = waterConnectionService;
    }

    @RequestMapping(value="/connection/v1/_create", method = RequestMethod.POST)
    public ResponseEntity<WaterConnectionResponse> v1ConnectionCreatePost(@ApiParam(value = "Details for the new Water Connection Application(s) + RequestInfo meta data." ,required=true )  @Valid @RequestBody WaterConnectionRequest waterConnectionRequest) {
        List<WaterConnectionApplication> applications = waterConnectionService.registerWcRequest(waterConnectionRequest);
        ResponseInfo responseInfo = responseInfoFactory.createResponseInfoFromRequestInfo(waterConnectionRequest.getRequestInfo(), true);
        WaterConnectionResponse response = WaterConnectionResponse.builder().waterConnectionApplications(applications).responseInfo(responseInfo).build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value="/v1/connection/_search", method = RequestMethod.POST)
    public ResponseEntity<WaterConnectionResponse> v1ConnectionSearchPost(@ApiParam(value = "Details for the new Water Connection Application(s) + RequestInfo meta data." ,required=true )  @Valid @RequestBody WaterApplicationSearchRequest waterApplicationSearchRequest) {
        List<WaterConnectionApplication> applications = waterConnectionService.searchWcApplications(waterApplicationSearchRequest.getRequestInfo(), waterApplicationSearchRequest.getWaterApplicationSearchCriteria());
        ResponseInfo responseInfo = responseInfoFactory.createResponseInfoFromRequestInfo(waterApplicationSearchRequest.getRequestInfo(), true);
        WaterConnectionResponse response = WaterConnectionResponse.builder().waterConnectionApplications(applications).responseInfo(responseInfo).build();
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @RequestMapping(value="/connection/v1/_update", method = RequestMethod.POST)
    public ResponseEntity<WaterConnectionResponse> v1ConnectionUpdatePost(@ApiParam(value = "Details for the new (s) + RequestInfo meta data." ,required=true )  @Valid @RequestBody WaterConnectionRequest waterConnectionRequest) {
        WaterConnectionApplication application = waterConnectionService.updateWcApplication(waterConnectionRequest);
        ResponseInfo responseInfo = responseInfoFactory.createResponseInfoFromRequestInfo(waterConnectionRequest.getRequestInfo(), true);
        WaterConnectionResponse response = WaterConnectionResponse.builder().waterConnectionApplications(Collections.singletonList(application)).responseInfo(responseInfo).build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}