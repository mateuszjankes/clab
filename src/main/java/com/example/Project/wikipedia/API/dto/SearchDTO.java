package com.example.Project.wikipedia.API.dto;

import lombok.Data;

@Data
public class SearchDTO {
    private String ns;
    private String title;
    private Long pageid;
    private Long size;
    private Long workcount;
    private String snippet;
    private String timestamp;
}
