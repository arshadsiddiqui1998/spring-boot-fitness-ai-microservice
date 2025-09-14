package com.fitness.activityservice.controller;

import com.fitness.activityservice.dto.ActivityDto;
import com.fitness.activityservice.service.ActivityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/activities")
@Slf4j
public class ActivityController {

    private final ActivityService activityService;

    @PostMapping
    public ResponseEntity<ActivityDto> trackActivity(@RequestBody ActivityDto activityDto) {
        log.info("Received request to track activity for userId: {}", activityDto.userId());

        ActivityDto savedActivity = activityService.trackActivity(activityDto);

        log.info("Activity tracked successfully with id: {}", savedActivity.id());
        return ResponseEntity.ok(savedActivity);
    }
}
