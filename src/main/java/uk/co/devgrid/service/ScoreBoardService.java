package uk.co.devgrid.service;

import uk.co.devgrid.model.Case;
import uk.co.devgrid.model.ScoreBoard;
import uk.co.devgrid.model.Submission;

public interface ScoreBoardService {
    void addCase(Case caseScoreBoard);

    boolean isCorrect(Submission submission);

    Integer calculatePenalty(Case caseScoreBoard, Submission submission);

    void persistContestantResult(Case caseScoredBoard, Integer idContestant, Integer penaltyTime);

    void generateScoreBoard(Case caseScoreBoard);

    void generateAllScoreBoards();

    String printScoreBoard(Case caseScoreBoard);

    String printAllScoreBoard();

    ScoreBoard getLatestScoredBoard();
}
