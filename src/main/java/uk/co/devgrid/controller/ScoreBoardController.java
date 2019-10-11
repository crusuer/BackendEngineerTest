package uk.co.devgrid.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.co.devgrid.service.ScoreBoardService;

@RestController
public class ScoreBoardController {
    @Autowired
    private ScoreBoardService scoreBoardService;

    @PostMapping("/scoreboard/submit")
    public void submitScoreBoard(){

    }
    @GetMapping("/scoreboard/retrieve")
    public void retrieveScoreBoard(){

    }
}
