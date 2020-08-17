package com.example.Project.wikipedia.API.service;

import com.example.Project.wikipedia.API.dto.ResultDTO;
import com.example.Project.wikipedia.API.dto.SearchDTO;
import com.example.Project.wikipedia.API.exception.InternalServerException;
import com.example.Project.wikipedia.API.response.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@Slf4j
@Service
public class WikiServiceImpl implements WikiService {

    @Value("${wikiApi.urlApi}")
    private String URL;

    @Value("${wikiApi.urlResponse}")
    private String URL_RESPONSE;

    RestTemplate restTemplate;

    public WikiServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Override
    public ApiResponse getClubByName(String name) {

        name = name.replaceAll("\\s+","_");

        URI uri = URI.create(URL + "?action=query&list=search&format=json&srsearch=%22" + name + "%22&srlimit=10");

        List<SearchDTO> searchDTOS;

        try {
            ResponseEntity<ResultDTO> responseEntity = restTemplate.getForEntity(uri, ResultDTO.class);
            searchDTOS = responseEntity.getBody().getQuery().getSearch();
        } catch (RestClientException e) {
            log.error("Server problem with api, check api." + e.getMessage());
            throw new InternalServerException("Server problem. Check api key.");
        }

        SearchDTO searchDTO = searchDTOS.get(0);

        String urlResponse = URL_RESPONSE + searchDTO.getTitle().replaceAll("\\s+","_");

        return new ApiResponse(searchDTO.getTitle(), urlResponse, searchDTO.getSnippet());
    }
}