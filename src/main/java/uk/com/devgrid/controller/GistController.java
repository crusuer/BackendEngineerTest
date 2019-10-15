package uk.com.devgrid.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uk.com.devgrid.dto.GistDTO;
import uk.com.devgrid.model.Gist;
import uk.com.devgrid.model.GistComment;
import uk.com.devgrid.service.GistService;

import javax.validation.Valid;

@RestController
public class GistController {
    @Autowired
    private GistService gistService;

    @GetMapping(path = "/gist/{gistId}/comments", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GistComment[]> retrieveGistComments(@PathVariable("gistId") String gistId) {
        return ResponseEntity.ok(gistService.retrieveGistComments(gistId));
    }

    @PostMapping(path = "/gist/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Gist> createGist(@Valid @RequestBody GistDTO gist) {
        return ResponseEntity.status(HttpStatus.CREATED).body(gistService.createGist(gist));
    }
}
