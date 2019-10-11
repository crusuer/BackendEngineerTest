package uk.co.devgrid.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Case {
    private Integer number;

    private List<Submission> submissions = new ArrayList<>();

    private List<Contestant> contestants = new ArrayList<>();

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public List<Submission> getSubmissions() {
        return submissions;
    }

    public void setSubmissions(List<Submission> submissions) {
        this.submissions = submissions;
    }

    public List<Contestant> getContestants() {
        return contestants;
    }

    public void setContestants(List<Contestant> contestants) {
        this.contestants = contestants;
    }

    public void addSubmission(Submission submission) {

        if (getSubmissions() == null) {
            setSubmissions(new ArrayList<>());
        }

        submissions.add(submission);
    }

    public void addContestants(Contestant contestant) {

        if (getContestants() == null) {
            setContestants(new ArrayList<>());
        }

        contestants.add(contestant);
    }
}
