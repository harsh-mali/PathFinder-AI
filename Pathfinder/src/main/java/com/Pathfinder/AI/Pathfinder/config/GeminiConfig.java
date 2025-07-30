package com.Pathfinder.AI.Pathfinder.config;

import com.google.genai.Client;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GeminiConfig {

    // 1. This annotation reads a value from your application.properties file.
    @Value("${gemini.api.key}")
    private String apiKey;

    // 2. The @Bean annotation tells Spring that this method creates an object
    //    that Spring should manage. You can now 'inject' this Client
    //    object into other classes, like your upcoming RoadmapService.
    @Bean
    public Client geminiClient(){
        // Note: The google-genai library automatically uses the GOOGLE_API_KEY
        // environment variable if it's set. This explicit setup is good for clarity
        // and can be adapted for other key management strategies in the future.
        return new Client();
    }
}