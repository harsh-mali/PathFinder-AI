package com.Pathfinder.AI.Pathfinder.service;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GeminiService {

    private final Client geminiClient;

    public String ask(String prompt){
        // In a real-world scenario, you'd add more robust error handling here.
        GenerateContentResponse response =
                geminiClient.models.generateContent(
                        "gemini-2.5-flash", // Or your preferred model
                        prompt,
                        null);

        return response.text();
    }
}