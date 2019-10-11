package uk.co.devgrid.model;

public class Submission {

    private Integer contestant;

    private Integer problem;

    private Integer time;

    private Situation status;

    public Integer getContestant() {
        return contestant;
    }

    public void setContestant(Integer contestant) {
        this.contestant = contestant;
    }

    public Integer getProblem() {
        return problem;
    }

    public void setProblem(Integer problem) {
        this.problem = problem;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Situation getStatus() {
        return status;
    }

    public void setStatus(Situation status) {
        this.status = status;
    }

}

