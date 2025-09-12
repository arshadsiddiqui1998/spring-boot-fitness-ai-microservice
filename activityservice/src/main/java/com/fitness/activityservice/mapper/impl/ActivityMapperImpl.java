package com.fitness.activityservice.mapper.impl;

import com.fitness.activityservice.dto.ActivityDto;
import com.fitness.activityservice.mapper.ActivityMapper;
import com.fitness.activityservice.model.Activity;
import org.springframework.stereotype.Component;

@Component
public class ActivityMapperImpl implements ActivityMapper<Activity, ActivityDto> {

    @Override
    public Activity dtoToEntity(ActivityDto activityDto) {
        return Activity.builder().userId(activityDto.userId())
                .type(activityDto.type())
                .duration(activityDto.duration())
                .caloriesBurned(activityDto.caloriesBurned())
                .startTime(activityDto.startTime())
                .additionalMetrics(activityDto.additionalMetrics())
                .build();
    }

    @Override
    public ActivityDto entityToDto(Activity activity) {
        return ActivityDto.builder()
                .id(activity.getId())
                .userId(activity.getUserId())
                .type(activity.getType())
                .duration(activity.getDuration())
                .caloriesBurned(activity.getCaloriesBurned())
                .startTime(activity.getStartTime())
                .additionalMetrics(activity.getAdditionalMetrics())
                .createdAt(activity.getCreatedAt())
                .updatedAt(activity.getUpdatedAt())
                .build();
    }
}
