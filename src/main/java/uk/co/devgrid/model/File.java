package uk.co.devgrid.model;

import lombok.Data;
import uk.co.devgrid.dto.FileDTO;

@Data
public class File extends FileDTO {
    private String filename;
    private String type;
    private String language;
    private String rawUrl;
    private Long size;
    private boolean truncated;
}
