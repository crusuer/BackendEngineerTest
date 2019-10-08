package uk.co.devgrid.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    private boolean publicFlag;
}
