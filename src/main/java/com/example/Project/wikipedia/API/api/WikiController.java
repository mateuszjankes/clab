package com.example.Project.wikipedia.API.api;

import com.example.Project.wikipedia.API.response.ApiResponse;
import com.example.Project.wikipedia.API.service.WikiServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "localhost:4200")
@RequestMapping(value = "/api")
public class WikiController {

    WikiServiceImpl wikiService;

    public WikiController(WikiServiceImpl wikiService) {
        this.wikiService = wikiService;
    }

    @GetMapping("/club")
    public ApiResponse getClub(@RequestParam ("name") String clubName) {
        return wikiService.getClubByName(clubName);
    }
}
