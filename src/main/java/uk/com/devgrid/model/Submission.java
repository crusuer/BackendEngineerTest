package uk.com.devgrid.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import uk.com.devgrid.enums.SubmissionResultEnum;

import java.util.regex.Pattern;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Submission {
    private int contestantId;
    private int questionNumber;
    private int timeExpended;
    private SubmissionResultEnum submissionResult;

    public Submission(String submission) {
        String[] values = submission.split(" ");
        this.contestantId = Integer.valueOf(values[0]);
        this.questionNumber = Integer.valueOf(values[1]);
        this.timeExpended = Integer.valueOf(values[2]);
        switch (values[3]) {
            case "C":
                this.submissionResult = SubmissionResultEnum.CORRECT;
                break;
            case "I":
                this.submissionResult = SubmissionResultEnum.INCORRECT;
                break;
            case "R":
                this.submissionResult = SubmissionResultEnum.CLARIFICATION_REQUEST;
                break;
            case "U":
                this.submissionResult = SubmissionResultEnum.UNJUDGED;
                break;
            case "E":
                this.submissionResult = SubmissionResultEnum.ERRONEOUS;
                break;
        }
    }
}

