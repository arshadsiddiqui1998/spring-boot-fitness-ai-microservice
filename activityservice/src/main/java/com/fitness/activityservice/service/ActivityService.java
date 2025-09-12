package com.fitness.activityservice.service;

import com.fitness.activityservice.dto.ActivityDto;
import com.fitness.activityservice.mapper.impl.ActivityMapperImpl;
import com.fitness.activityservice.model.Activity;
import com.fitness.activityservice.respository.ActivityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ActivityService {

    private final ActivityRepository activityRepository;
    private final ActivityMapperImpl activityMapper;

    public ActivityDto trackActivity(ActivityDto activityDto) {
        log.info("In trackActivity() -> activityDto: {}", activityDto);
        Activity activity = activityMapper.dtoToEntity(activityDto);
        Activity save = activityRepository.save(activity);
        return activityMapper.entityToDto(save);
    }
}
