package uk.co.devgrid.model;

import lombok.Data;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Data
public class Gist {
    private String url;
    private String forksUrl;
    private String commitsUrl;
    private String id;
    private String nodeId;
    private String gitPullUrl;
    private String gitPushUrl;
    private String htmlUrl;
    private Map<String, File> files = new HashMap<>();
    private boolean publicFlag;
    private Date createdAt;
    private Date updatedAt;
    private String description;
    private Long comments;
    private User user;
    private String commentsUrl;
    private Owner owner;
    private boolean truncated;
    //ArrayList < Object > forks = new ArrayList < Object > ();
    //ArrayList < Object > history = new ArrayList < Object > ();
}
