package uk.com.devgrid.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class GistComment {
    private String body;

    @JsonProperty(value = "comment")
    public String getBody() {
        return body;
    }

    @JsonProperty(value = "body")
    public void setBody(String body) {
        this.body = body;
    }
}
