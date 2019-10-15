package uk.co.devgrid.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Case {
    private Integer number;
    private List<Submission> submissions = new ArrayList<>();
}
