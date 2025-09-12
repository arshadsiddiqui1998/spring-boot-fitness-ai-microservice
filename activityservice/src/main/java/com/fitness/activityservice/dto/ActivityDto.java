package com.fitness.activityservice.dto;

import com.fitness.activityservice.model.ActivityType;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.Map;

@Builder
public record ActivityDto(
        String id,
        String userId,
        ActivityType type,
        Integer duration,
        Integer caloriesBurned,
        LocalDateTime startTime,
        Map<String, Object> additionalMetrics,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
