package uk.co.devgrid.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uk.co.devgrid.dto.GistDTO;
import uk.co.devgrid.model.Gist;
import uk.co.devgrid.model.GistComment;
import uk.co.devgrid.service.GistService;

import java.util.List;

@RestController
public class MainController {
    @Autowired
    GistService gistService;

    @GetMapping("/gist/list/comments")
    public List<GistComment> comments(@RequestParam("gist_id") String gistId) {
        return gistService.comments(gistId);
    }

    @PostMapping("/gist/create")
    public Gist create(@RequestBody GistDTO gistDTO) {
        return gistService.create(gistDTO);
    }
}
