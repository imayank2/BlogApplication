package com.blogApplication.service.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class OpenAIService {
    @Value("${openai.api.key}")
    private String apiKey;

    @Value("${openai.api.url}")
    private String apiUrl;

    public String generateSummary(String text) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(apiKey);

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("model", "gpt-3.5-turbo");
        requestBody.put("messages", new Object[] {
                new HashMap<String, String>() {{
                    put("role", "system");
                    put("content", "You are a helpful assistant that summarizes text.");
                }},
                new HashMap<String, String>() {{
                    put("role", "user");
                    put("content", "Summarize the following blog post in 2-3 sentences: " + text);
                }}
        });
        requestBody.put("max_tokens", 150);
        requestBody.put("temperature", 0.7);

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(requestBody, headers);

        ResponseEntity<Map> response = restTemplate.exchange(
                apiUrl,
                HttpMethod.POST,
                entity,
                Map.class
        );

        Map<String, Object> responseBody = response.getBody();
        if (responseBody != null && responseBody.containsKey("choices")) {
            Map<String, Object> choice = ((Map<String, Object>) ((java.util.List<?>) responseBody.get("choices")).get(0));
            Map<String, String> message = (Map<String, String>) choice.get("message");
            return message.get("content");
        }

        return "Unable to generate summary";
    }
}
