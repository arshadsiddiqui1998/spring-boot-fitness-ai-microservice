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
    private final UserValidationService userValidationService;

    public ActivityDto trackActivity(ActivityDto activityDto) {
    boolean isValidUser=userValidationService.validateUser(activityDto.userId());
    if (!isValidUser) {
     throw new RuntimeException("Invalid user"+activityDto.userId());
    }
        log.info("In trackActivity() -> activityDto: {}", activityDto);
        Activity activity = activityMapper.dtoToEntity(activityDto);
        Activity save = activityRepository.save(activity);
        return activityMapper.entityToDto(save);
    }
}
