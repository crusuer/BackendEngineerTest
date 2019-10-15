package uk.com.devgrid.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GistDTO {
    @NonNull
    private Map<String, FileDTO> files = new HashMap<>();
    private String description;
    @JsonProperty("public")
    private boolean publicFlag;
}
