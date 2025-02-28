package digit.web.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.egov.common.contract.models.Workflow;
import org.egov.common.contract.request.RequestInfo;
import org.springframework.validation.annotation.Validated;

/**
 * WaterConnectionWorkflowUpdateRequest
 */
@Validated
@jakarta.annotation.Generated(value = "org.egov.codegen.SpringBootCodegen", date = "2025-01-07T15:17:21.586197+05:30[Asia/Kolkata]")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WaterConnectionWorkflowUpdateRequest {
    @JsonProperty("RequestInfo")
    @NotNull

    @Valid
    private RequestInfo requestInfo = null;

    @JsonProperty("workflow")
    @NotNull

    @Valid
    private Workflow workflow = null;


}