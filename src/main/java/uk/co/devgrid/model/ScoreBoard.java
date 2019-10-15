package uk.co.devgrid.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ScoreBoard {
    private int contestantId;
    private int problemsSolved;
    private int timeExpended;

    @Override
    public String toString(){
        String space = " ";
        String breakLine = "\n";

        return new StringBuilder()
                .append(contestantId)
                .append(space)
                .append(problemsSolved)
                .append(space)
                .append(timeExpended)
                .append(breakLine)
                .toString();
    }
}
