package uk.co.devgrid.service;

import uk.co.devgrid.dto.GistDTO;
import uk.co.devgrid.model.Gist;
import uk.co.devgrid.model.GistComment;

import java.util.List;

public interface GistService {
    List<GistComment> comments(String gistId);

    Gist create(GistDTO gistDTO);
}
