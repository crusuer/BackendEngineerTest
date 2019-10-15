package uk.co.devgrid.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum SubmissionResultEnum {
    CORRECT("C"),
    INCORRECT("I"),
    CLARIFICATION_REQUEST("R"),
    UNJUDGED("U"),
    ERRONEOUS("E");

    @Getter
    private String value;
}
