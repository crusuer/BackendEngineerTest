package uk.com.devgrid.service;

import uk.com.devgrid.dto.ScoreBoardDTO;
import uk.com.devgrid.model.Case;

import java.util.List;

public interface ScoreBoardService {

    List<Case> submitScoreBoard(ScoreBoardDTO scoreBoardDTO);

    ScoreBoardDTO retrieveLatestScoreBoard();
}
