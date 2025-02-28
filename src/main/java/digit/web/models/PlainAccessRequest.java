package digit.web.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.Builder;

/**
 * PlainAccessRequest
 */
@Validated
@jakarta.annotation.Generated(value = "org.egov.codegen.SpringBootCodegen", date = "2025-02-17T20:56:21.724071100+05:30[Asia/Calcutta]")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PlainAccessRequest   {
        @JsonProperty("plainRequestFields")

                private List<String> plainRequestFields = null;

        @JsonProperty("recordId")

                private String recordId = null;


        public PlainAccessRequest addPlainRequestFieldsItem(String plainRequestFieldsItem) {
            if (this.plainRequestFields == null) {
            this.plainRequestFields = new ArrayList<>();
            }
        this.plainRequestFields.add(plainRequestFieldsItem);
        return this;
        }

}
