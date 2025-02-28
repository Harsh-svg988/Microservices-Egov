package digit.web.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.Builder;

/**
 * Contract class to receive request. Array of Property items  are used in case of create . Where as single Property item is used for update
 */
@Schema(description = "Contract class to receive request. Array of Property items  are used in case of create . Where as single Property item is used for update")
@Validated
@jakarta.annotation.Generated(value = "org.egov.codegen.SpringBootCodegen", date = "2025-02-17T20:56:21.724071100+05:30[Asia/Calcutta]")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WaterConnectionRequest   {
        @JsonProperty("RequestInfo")

          @Valid
                private RequestInfo requestInfo = null;

        @JsonProperty("WaterConnection")

          @Valid
                private WaterConnection waterConnection = null;

        @JsonProperty("disconnectRequest")

                private Boolean disconnectRequest = null;

        @JsonProperty("isCreateCall")

                private Boolean isCreateCall = null;

        @JsonProperty("isOldDataEncryptionRequest")

                private Boolean isOldDataEncryptionRequest = null;


}
