package uk.co.devgrid.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import uk.co.devgrid.dto.GistDTO;
import uk.co.devgrid.model.Gist;
import uk.co.devgrid.model.GistComment;
import uk.co.devgrid.service.GistService;

import java.util.ArrayList;
import java.util.List;

@Service
public class GistServiceImpl implements GistService {
    private static final Logger LOGGER = LogManager.getLogger(GistServiceImpl.class);

    @Autowired
    RestTemplate restTemplate;

    @Override
    public List<GistComment> comments(String gistId) {
        List gistComments = new ArrayList<>();
        try {
            gistComments = restTemplate.getForObject(
                    "https://api.github.com/gists/".concat(gistId).concat("/comments"), List.class);
        } catch (HttpClientErrorException e) {
            LOGGER.error("Status: {}, Response: {}, StackTrace: {}, ",
                    e.getStatusCode(), e.getResponseBodyAsString(), e.getStackTrace());
        }
        return gistComments;
    }

    @Override
    public Gist create(GistDTO gistDTO) {
        //HttpEntity<String> request = new HttpEntity<String>(personJsonObject.toString(), headers);
        //Gist createdGist = restTemplate.postForObject("https://api.github.com/gists", request, Gist.class);
        //return createdGist;
        LOGGER.info(gistDTO);
        return new Gist();
    }
}
