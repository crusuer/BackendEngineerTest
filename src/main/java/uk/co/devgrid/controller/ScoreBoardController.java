package uk.co.devgrid.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import uk.co.devgrid.dto.ScoreBoardDTO;
import uk.co.devgrid.service.ScoreBoardService;

import javax.validation.Valid;

@RestController
public class ScoreBoardController {
    @Autowired
    private ScoreBoardService scoreBoardService;

    @PostMapping("/scoreboard/submit")
    public void submitScoreBoard(@RequestBody @Valid ScoreBoardDTO scoreBoard) {
        //scoreBoardService.submitScoreBoard(scoreBoard);
    }

    @GetMapping(value = "/scoreboard/retrieve", produces = "application/json")
    public ResponseEntity<ScoreBoardDTO> retrieveScoreBoard() {
        ScoreBoardDTO scoreBoardDTO = scoreBoardService.retrieveLatestScoreBoard();
        return ResponseEntity.ok(scoreBoardDTO);
    }
}
