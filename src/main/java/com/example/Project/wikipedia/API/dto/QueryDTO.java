package com.example.Project.wikipedia.API.dto;

import lombok.Data;

import java.util.List;

@Data
public class QueryDTO {
    private List<SearchDTO> search;
}
