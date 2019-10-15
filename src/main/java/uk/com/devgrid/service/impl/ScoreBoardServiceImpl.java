package uk.com.devgrid.service.impl;

import org.springframework.stereotype.Service;
import uk.com.devgrid.dto.ScoreBoardDTO;
import uk.com.devgrid.model.Case;
import uk.com.devgrid.model.ContestantResult;
import uk.com.devgrid.service.ScoreBoardService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ScoreBoardServiceImpl implements ScoreBoardService {
    private static final int PENALTY_FACTOR = 20;
    private List<Case> cases = new ArrayList<>();
    private List<ContestantResult> results = new ArrayList<>();

    @Override
    public List<Case> submitScoreBoard(ScoreBoardDTO scoreBoardDTO) {
        String[] content = scoreBoardDTO.getContent().split("\\r?\\n\\r?\\n");

        Arrays.asList(content)
                .stream()
                .skip(1)
                .forEach(caseSubmitted -> cases.add(new Case(caseSubmitted)));
        return cases;
    }

    private void populateContestantResult() {
        if (!cases.isEmpty()) {
            Case lastCase = cases.get(cases.size() - 1);
            lastCase.getContestantSubmissions()
                    .stream();
                  //  .forEach(submission -> {results.add(new Co);});
        }
    }

    @Override
    public ScoreBoardDTO retrieveLatestScoreBoard() {

        StringBuilder resultBuilder = new StringBuilder();

        //List<ContestantResult> latestScoreBoard = results.get(results.size() - 1);
        /*new ArrayList<>(
                Arrays.asList(
                        new ContestantResult(1),
                        new ContestantResult(3)
                )
        );
        latestScoreBoard.get(0).increaseTimeExpended(56);
        latestScoreBoard.get(0).addProblemSolved(1);
        latestScoreBoard.get(0).increaseTimeExpended(10);
        latestScoreBoard.get(0).addProblemSolved(2);

        latestScoreBoard.get(1).increaseTimeExpended(11);
        latestScoreBoard.get(1).addProblemSolved(1);*/

        //latestScoreBoard.forEach(resultBuilder::append);

        return new ScoreBoardDTO(resultBuilder.toString());
    }

}
