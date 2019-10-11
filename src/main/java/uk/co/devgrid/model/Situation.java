package uk.co.devgrid.model;

public enum Situation {

    C("Correct"),
    I("Incorrect"),
    R("Clarification Request"),
    U("Unjuged"),
    E("Erroneous");

    private String description;

    private Situation(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
