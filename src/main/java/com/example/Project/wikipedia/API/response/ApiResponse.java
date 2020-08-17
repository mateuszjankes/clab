package com.example.Project.wikipedia.API.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class ApiResponse {
    private String name;
    private String url;
    private String snippet;
}
