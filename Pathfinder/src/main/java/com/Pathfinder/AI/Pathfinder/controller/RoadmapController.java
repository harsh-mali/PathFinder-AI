package com.Pathfinder.AI.Pathfinder.controller;

import com.Pathfinder.AI.Pathfinder.dto.RoadmapRequest;
import com.Pathfinder.AI.Pathfinder.service.RoadmapService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/roadmaps")
@RequiredArgsConstructor
public class RoadmapController {

    private final RoadmapService roadmapService;

    @PostMapping("/generate")
    public ResponseEntity<String> generateRoadmap(@RequestBody RoadmapRequest request) {
        // This endpoint is automatically protected by Spring Security
        // because it's not listed as 'permitAll' in your SecurityConfiguration.
        String roadmapJson = roadmapService.generateRoadmap(request);
        return ResponseEntity.ok(roadmapJson);
    }
}