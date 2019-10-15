package uk.com.devgrid.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Case {
    @JsonProperty("case")
    private List<Submission> contestantSubmissions = new ArrayList<>();

    public Case(String caseSubmitted) {
        String[] submissions = caseSubmitted.split("\\r?\\n");
        Arrays.asList(submissions).stream()
                .forEach(submission -> contestantSubmissions.add(new Submission(submission)));
    }
}
