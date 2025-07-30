package com.Pathfinder.AI.Pathfinder.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoadmapRequest {
    private String topic;
    private String skillLevel;
    private String timeCommitment;
    private String totalTimeframe;
}