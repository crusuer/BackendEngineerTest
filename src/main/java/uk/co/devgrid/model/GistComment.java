package uk.co.devgrid.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.Date;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GistComment {
    private String url;
    private Long id;
    private String nodeId;
    private User user;
    private String authorAssociation;
    private Date createdAt;
    private Date updatedAt;
    private String body;
}
