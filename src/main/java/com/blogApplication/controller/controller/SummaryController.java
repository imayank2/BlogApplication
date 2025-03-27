package com.blogApplication.controller.controller;


import com.blogApplication.service.service.OpenAIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/summarize")
public class SummaryController {
    @Autowired
    private OpenAIService openAIService;

    @PostMapping
    public ResponseEntity<String> summarizeText(@RequestBody String text) {
        String summary = openAIService.generateSummary(text);
        return ResponseEntity.ok(summary);
    }
}
