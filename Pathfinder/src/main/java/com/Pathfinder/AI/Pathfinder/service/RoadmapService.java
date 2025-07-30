package com.Pathfinder.AI.Pathfinder.service;

import com.Pathfinder.AI.Pathfinder.dto.RoadmapRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoadmapService {

    private final GeminiService geminiService;

    public String generateRoadmap(RoadmapRequest request) {
        // Here we build the detailed prompt from our previous discussion
        String prompt = """
                You are an expert curriculum designer. Based on the user's goals, create a detailed learning roadmap.
                Return the response as a single, minified JSON object and nothing else.

                **User Goals:**
                - Topic to Learn: %s
                - Current Skill Level: %s
                - Time Commitment: %s
                - Total Timeframe: %s

                **JSON Structure:**
                {
                  "mainGoal": "A concise title for the user's objective.",
                  "totalDuration": "%s",
                  "phases": [
                    {
                      "phaseTitle": "Phase 1: [Name of Phase]",
                      "duration": "Week 1-2",
                      "topics": [
                        {
                          "topicName": "Name of the first topic",
                          "estimatedHours": 8,
                          "description": "A brief, one-sentence description of this topic."
                        }
                      ],
                      "project": {
                        "projectName": "Name of the mini-project for this phase",
                        "projectDescription": "A one-sentence description of the project's goal."
                      }
                    }
                  ]
                }
                """.formatted(
                request.getTopic(),
                request.getSkillLevel(),
                request.getTimeCommitment(),
                request.getTotalTimeframe(),
                request.getTotalTimeframe()
        );

        return geminiService.ask(prompt);
    }
}