package uk.co.devgrid.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import uk.co.devgrid.enums.SubmissionResultEnum;

@Data
@AllArgsConstructor
public class Submission {
    private int id;
    private int questionNumber;
    private int timeExpended;
    private SubmissionResultEnum submissionResult;
}

