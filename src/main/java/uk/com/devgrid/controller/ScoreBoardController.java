package uk.com.devgrid.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import uk.com.devgrid.dto.ScoreBoardDTO;
import uk.com.devgrid.model.Case;
import uk.com.devgrid.service.ScoreBoardService;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ScoreBoardController {
    private static final Logger LOGGER = LogManager.getLogger(ScoreBoardController.class);
    @Autowired
    private ScoreBoardService scoreBoardService;

    @PostMapping(path = "/scoreboard/submit", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Case>> submitScoreBoard() {
        //TODO RequestBody ScoreBoard
        ScoreBoardDTO scoreBoard = new ScoreBoardDTO("1\n\n1 2 10 I\n3 1 11 C\n1 2 19 R\n1 2 21 C\n1 1 25 C");
        List<Case> cases = scoreBoardService.submitScoreBoard(scoreBoard);
        return ResponseEntity.status(HttpStatus.CREATED).body(cases);
    }

    @GetMapping(value = "/scoreboard/retrieve/latest", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ScoreBoardDTO> retrieveLatestScoreBoard() {
        ScoreBoardDTO latestScoreBoard = scoreBoardService.retrieveLatestScoreBoard();
        return ResponseEntity.ok(latestScoreBoard);
    }
}
