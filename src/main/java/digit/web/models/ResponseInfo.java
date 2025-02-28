package digit.web.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.validation.annotation.Validated;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.Builder;

/**
 * ResponseInfo
 */
@Validated
@jakarta.annotation.Generated(value = "org.egov.codegen.SpringBootCodegen", date = "2025-02-17T20:56:21.724071100+05:30[Asia/Calcutta]")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseInfo   {
        @JsonProperty("apiId")

                private String apiId = null;

        @JsonProperty("msgId")

                private String msgId = null;

        @JsonProperty("resMsgId")

                private String resMsgId = null;

        @JsonProperty("status")

                private String status = null;

        @JsonProperty("ts")

                private Long ts = null;

        @JsonProperty("ver")

                private String ver = null;


}
