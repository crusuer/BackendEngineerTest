package uk.co.devgrid.model;

public class Contestant implements Comparable<Contestant> {

    private Integer id;

    private Integer problemsSolved;

    private Long penaltyTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProblemsSolved() {
        return problemsSolved;
    }

    public void setProblemsSolved(Integer problemsSolved) {
        this.problemsSolved = problemsSolved;
    }

    public Long getPenaltyTime() {
        return penaltyTime;
    }

    public void setPenaltyTime(Long penaltyTime) {
        this.penaltyTime = penaltyTime;
    }

    @Override
    public int compareTo(Contestant o) {

        if (getProblemsSolved() != null && o.getProblemsSolved() != null && getProblemsSolved().compareTo(o.getProblemsSolved()) > 0) {
            return -1;
        }

        if (getPenaltyTime() != null && o.getPenaltyTime() != null && getPenaltyTime().compareTo(o.getPenaltyTime()) < 0) {
            return -1;
        }

        return getId().compareTo(o.getId());
    }

}
