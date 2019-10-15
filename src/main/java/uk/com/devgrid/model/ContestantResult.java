package uk.com.devgrid.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;

import java.util.BitSet;

@Getter
@EqualsAndHashCode
public class ContestantResult {
    private int contestantId;
    private BitSet problemsSolved = new BitSet();
    private int timeExpended;

    public ContestantResult(int contestantId){
        this.contestantId = contestantId;
    }

    public void increaseTimeExpended(int timeExpended) {
        this.timeExpended += timeExpended;
    }

    public void addProblemSolved(int problem) {
        problemsSolved.set(problem);
    }

    @Override
    public String toString() {
        String space = " ";
        String breakLine = "\n";

        return new StringBuilder()
                .append(contestantId)
                .append(space)
                .append(problemsSolved.cardinality())
                .append(space)
                .append(timeExpended)
                .append(breakLine)
                .toString();
    }

}
