package uk.co.devgrid.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScoreBoardController {
    @PostMapping("/scoreboard/submit")
    public void submitScoreBoard(){

    }
    @GetMapping("/scoreboard/retrieve")
    public void retrieveScoreBoard(){

    }
}
