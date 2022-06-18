package com.ajsw.javacoursesservice.controllers;

import com.ajsw.javacoursesservice.models.entities.Activity;
import com.ajsw.javacoursesservice.services.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/activities")
public class ActivityController {
    private final ActivityService activityService;

    @Autowired
    public ActivityController(ActivityService activityService){
        this.activityService = activityService;
    }

    @GetMapping()
    public List<Activity> getActivities(){  return  activityService.getAll(); }
}
