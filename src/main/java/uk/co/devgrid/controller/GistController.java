package uk.co.devgrid.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uk.co.devgrid.dto.GistDTO;
import uk.co.devgrid.model.Gist;
import uk.co.devgrid.model.GistComment;
import uk.co.devgrid.service.GistService;

import javax.validation.Valid;

@RestController
public class GistController {
    @Autowired
    GistService gistService;

    @GetMapping(path = "/gist/{gistId}/comments", produces = MediaType.APPLICATION_JSON_VALUE)
    public GistComment[] comments(@PathVariable("gistId") String gistId) {
        return gistService.comments(gistId);
    }

    @PostMapping(path = "/gist/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Gist> create(@Valid @RequestBody GistDTO gistDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(gistService.create(gistDTO));
    }
}
