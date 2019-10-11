package uk.co.devgrid.service.impl;

import org.springframework.stereotype.Service;
import uk.co.devgrid.model.*;
import uk.co.devgrid.service.ScoreBoardService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ScoreBoardServiceImpl implements ScoreBoardService {
    private static final int PENALTY_FACTOR = 20;
    private List<Case> listCases = new ArrayList<>();

    @Override
    public void addCase(Case caseScoreBoard) {
        listCases.add(caseScoreBoard);
    }

    @Override
    public boolean isCorrect(Submission submission) {

        if (submission != null && Situation.C.equals(submission.getStatus())) {
            return true;
        }

        return false;

    }

    @Override
    public Integer calculatePenalty(Case caseScoreBoard, Submission submission) {

        long wrongAttempts = caseScoreBoard.getSubmissions().stream().filter(s -> s.getContestant().equals(submission.getContestant())
                && s.getProblem().equals(submission.getProblem()) && s.getStatus().equals(Situation.I)).count();

        Long penalty = submission.getTime() + wrongAttempts * PENALTY_FACTOR;

        return penalty.intValue();
    }

    @Override
    public void persistContestantResult(Case caseScoredBoard, Integer idContestant, Integer penaltyTime) {

        if (caseScoredBoard.getContestants() == null) {
            caseScoredBoard.setContestants(new ArrayList<>());
        }

        Optional<Contestant> optionalContestant = caseScoredBoard.getContestants().stream().filter(c -> c.getId().equals(idContestant)).findFirst();

        Contestant contestant;
        if (optionalContestant.isPresent()) {
            contestant = optionalContestant.get();
        } else {
            contestant = new Contestant();
            contestant.setId(idContestant);
            contestant.setProblemsSolved(0);
            contestant.setPenaltyTime(0l);
            caseScoredBoard.addContestants(contestant);
        }

        contestant.setProblemsSolved(contestant.getProblemsSolved() + 1);
        contestant.setPenaltyTime(contestant.getPenaltyTime() + penaltyTime);

    }

    @Override
    public void generateScoreBoard(Case caseScoreBoard) {

        if (caseScoreBoard != null && caseScoreBoard.getSubmissions() != null) {

            for (Submission submission : caseScoreBoard.getSubmissions()) {

                if (isCorrect(submission)) {
                    Integer penalty = calculatePenalty(caseScoreBoard, submission);

                    persistContestantResult(caseScoreBoard, submission.getContestant(), penalty);

                }

            }
        }

        Collections.sort(caseScoreBoard.getContestants());

    }

    @Override
    public void generateAllScoreBoards() {

        if (listCases != null) {
            for (Case caseScoreBoard : listCases) {

                generateScoreBoard(caseScoreBoard);

            }
        }

    }

    @Override
    public String printScoreBoard(Case caseScoreBoard) {

        if (caseScoreBoard.getContestants() != null) {

            StringBuilder sb = new StringBuilder();

            sb.append("Case: ");
            sb.append(caseScoreBoard.getNumber());
            sb.append("\n");

            for (Contestant contestant : caseScoreBoard.getContestants()) {

                sb.append(String.format("%d %d %d \n", contestant.getId(), contestant.getProblemsSolved(), contestant.getPenaltyTime()));
            }
            sb.append("\n");

            return sb.toString();
        }

        return null;
    }

    @Override
    public String printAllScoreBoard() {

        if (listCases != null) {

            StringBuilder sb = new StringBuilder();

            for (Case caseScoreBoard : listCases) {
                sb.append(printScoreBoard(caseScoreBoard));
            }

            return sb.toString();
        }

        return null;
    }

    @Override
    public ScoreBoard getLatestScoredBoard() {
        Case caseScoreBoard = listCases.get(listCases.size() - 1);

        ScoreBoard result = new ScoreBoard();

        result.setResult(printScoreBoard(caseScoreBoard));

        return result;
    }

}
