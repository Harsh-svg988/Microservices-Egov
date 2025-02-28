package digit.web.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.validation.annotation.Validated;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.Builder;

/**
 * AuditDetails
 */
@Validated
@jakarta.annotation.Generated(value = "org.egov.codegen.SpringBootCodegen", date = "2025-02-17T20:56:21.724071100+05:30[Asia/Calcutta]")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuditDetails   {
        @JsonProperty("createdBy")

                private String createdBy = null;

        @JsonProperty("createdTime")

                private Long createdTime = null;

        @JsonProperty("lastModifiedBy")

                private String lastModifiedBy = null;

        @JsonProperty("lastModifiedTime")

                private Long lastModifiedTime = null;


}
