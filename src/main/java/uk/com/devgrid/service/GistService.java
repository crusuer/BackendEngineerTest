package uk.com.devgrid.service;

import uk.com.devgrid.dto.GistDTO;
import uk.com.devgrid.model.Gist;
import uk.com.devgrid.model.GistComment;

public interface GistService {
    GistComment[] retrieveGistComments(String gistId);

    Gist createGist(GistDTO gistDTO);
}
