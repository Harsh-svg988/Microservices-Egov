package digit.web.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.Builder;

/**
 * Role
 */
@Validated
@jakarta.annotation.Generated(value = "org.egov.codegen.SpringBootCodegen", date = "2025-02-17T20:56:21.724071100+05:30[Asia/Calcutta]")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Role   {
        @JsonProperty("code")

        @Size(max=50)         private String code = null;

        @JsonProperty("id")

                private Long id = null;

        @JsonProperty("name")

        @Size(max=128)         private String name = null;

        @JsonProperty("tenantId")

        @Size(max=256)         private String tenantId = null;


}
