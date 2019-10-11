package uk.co.devgrid.service;

import uk.co.devgrid.dto.GistDTO;
import uk.co.devgrid.model.Gist;
import uk.co.devgrid.model.GistComment;

public interface GistService {
    GistComment[] retrieveGistComments(String gistId);

    Gist createGist(GistDTO gistDTO);
}
