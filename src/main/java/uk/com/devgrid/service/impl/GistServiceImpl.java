package uk.com.devgrid.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import uk.com.devgrid.dto.GistDTO;
import uk.com.devgrid.model.Gist;
import uk.com.devgrid.model.GistComment;
import uk.com.devgrid.service.GistService;


@Service
public class GistServiceImpl implements GistService {
    private static final Logger LOGGER = LogManager.getLogger(GistServiceImpl.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HttpHeaders httpHeaders;

    @Override
    public GistComment[] retrieveGistComments(String gistId) {
        try {
            return restTemplate.getForObject(
                    "https://api.github.com/gists/".concat(gistId).concat("/comments"), GistComment[].class);
        } catch (HttpClientErrorException e) {
            LOGGER.error("Status: {}, Response: {}, StackTrace: {}, ",
                    e.getStatusCode(), e.getResponseBodyAsString(), e.getStackTrace());
        }
        return new GistComment[0];
    }

    @Override
    public Gist createGist(GistDTO gistDTO) {
        HttpEntity<GistDTO> request = new HttpEntity<>(gistDTO, httpHeaders);
        return restTemplate.postForObject("https://api.github.com/gists", request, Gist.class);
    }
}
