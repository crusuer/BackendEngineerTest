package uk.co.devgrid.model;

import java.util.BitSet;

public class Contestant implements Comparable<Contestant> {

    private int number;
    private BitSet problemsSolved;
    private int penaltyTime;

    public Contestant(int number) {
        this.number = number;
        this.problemsSolved = new BitSet();
        this.penaltyTime = 0;
    }

    public int getNumber() {
        return number;
    }

    public BitSet getProblemsSolved() {
        return problemsSolved;
    }

    public int getPenaltyTime() {
        return penaltyTime;
    }

    public void addPenaltyTime(int penaltyTime) {
        this.penaltyTime += penaltyTime;
    }

    public void addProblemSolved(int problem) {
        problemsSolved.set(problem);
    }

    @Override
    public String toString() {
        return number + " " + problemsSolved.cardinality() + " " + penaltyTime;
    }

    @Override
    public int compareTo(Contestant other) {
        int i = Integer.compare(other.getProblemsSolved().cardinality(), problemsSolved.cardinality());
        if (i != 0) return i;

        i = Integer.compare(penaltyTime, other.getPenaltyTime());
        if (i != 0) return i;
        
        i = Integer.compare(number, other.getNumber());
        return i;
    }

}
