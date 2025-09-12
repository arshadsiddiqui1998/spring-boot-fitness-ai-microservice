package com.fitness.activityservice.controller;

import com.fitness.activityservice.dto.ActivityDto;
import com.fitness.activityservice.service.ActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/activities")
public class ActivityController {

    private final ActivityService activityService;

    @PostMapping
    public ResponseEntity<ActivityDto> trackActivity(@RequestBody ActivityDto activityDto){
        return ResponseEntity.ok(activityService.trackActivity(activityDto));

    }
}
