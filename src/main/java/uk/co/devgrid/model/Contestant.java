package uk.co.devgrid.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.BitSet;

@Getter
@EqualsAndHashCode
@AllArgsConstructor
public class Contestant {

    private int number;
    private BitSet problemsSolved = new BitSet();
    private int timeExpended;

    public void increaseTimeExpended(int timeExpended) {
        this.timeExpended += timeExpended;
    }

    public void addProblemSolved(int problem) {
        problemsSolved.set(problem);
    }

}
