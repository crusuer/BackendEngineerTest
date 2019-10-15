package uk.co.devgrid.service.impl;

import org.springframework.stereotype.Service;
import uk.co.devgrid.dto.ScoreBoardDTO;
import uk.co.devgrid.enums.SubmissionResultEnum;
import uk.co.devgrid.model.ScoreBoard;
import uk.co.devgrid.model.Submission;
import uk.co.devgrid.service.ScoreBoardService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ScoreBoardServiceImpl implements ScoreBoardService {
    private static final int PENALTY_FACTOR = 20;

    public void submitScoreBoard(ScoreBoardDTO scoreBoardDTO) {
        List<Submission> submissions = new ArrayList<>();
        submissions.add(new Submission(1, 2, 10, SubmissionResultEnum.INCORRECT));
        submissions.add(new Submission(3, 1, 11, SubmissionResultEnum.CORRECT));
        submissions.add(new Submission(1, 2, 19, SubmissionResultEnum.CLARIFICATION_REQUEST));
        submissions.add(new Submission(1, 2, 21, SubmissionResultEnum.CORRECT));
        submissions.add(new Submission(1, 1, 25, SubmissionResultEnum.CORRECT));
    }

    @Override
    public ScoreBoardDTO retrieveLatestScoreBoard() {

        StringBuilder resultBuilder = new StringBuilder();

        List<ScoreBoard> latestScoreBoard = new ArrayList<>(
                Arrays.asList(
                        new ScoreBoard(1, 2, 66),
                        new ScoreBoard(3, 1, 11)
                )
        );

        latestScoreBoard.forEach(resultBuilder::append);

        return new ScoreBoardDTO(resultBuilder.toString());
    }

}
