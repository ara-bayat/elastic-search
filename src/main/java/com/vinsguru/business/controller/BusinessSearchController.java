package com.vinsguru.business.controller;

import com.vinsguru.business.dto.SuggestionRequestParameters;
import com.vinsguru.business.service.SuggestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RequiredArgsConstructor
@RestController
public class BusinessSearchController {
    private final SuggestionService  suggestionService;

    @GetMapping("/api/suggestion")
    public List<String> getSuggestions(@RequestBody SuggestionRequestParameters parameters){
        return suggestionService.fetchSuggestions(parameters);

    }

}
