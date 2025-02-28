package digit.web.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.egov.common.contract.response.ResponseInfo;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.List;

/**
 * Contains the ResponseHeader and the created/updated property
 */
@Schema(description = "Contains the ResponseHeader and the created/updated property")
@Validated
@jakarta.annotation.Generated(value = "org.egov.codegen.SpringBootCodegen", date = "2025-01-07T15:17:21.586197+05:30[Asia/Kolkata]")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WaterConnectionResponse {
    @JsonProperty("ResponseInfo")

    @Valid
    private ResponseInfo responseInfo = null;

    @JsonProperty("WaterConnection")
    @Valid
    private List<WaterConnection> waterConnection = null;


    public WaterConnectionResponse addWaterConnectionItem(WaterConnection waterConnectionItem) {
        if (this.waterConnection == null) {
            this.waterConnection = new ArrayList<>();
        }
        this.waterConnection.add(waterConnectionItem);
        return this;
    }

}