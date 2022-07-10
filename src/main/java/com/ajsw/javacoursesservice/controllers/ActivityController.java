package com.ajsw.javacoursesservice.controllers;

import com.ajsw.javacoursesservice.models.dtos.request.ActivityRequest;
import com.ajsw.javacoursesservice.models.dtos.request.UpdateCourseRequest;
import com.ajsw.javacoursesservice.models.dtos.response.Response;
import com.ajsw.javacoursesservice.models.entities.Activity;
import com.ajsw.javacoursesservice.services.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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

    @PostMapping()
    public Response createActivity(@Validated @RequestBody ActivityRequest activityRequest){
        try {
            return activityService.save(activityRequest);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "BAD REQUEST\n");
        }
    }

    @DeleteMapping(value = "/{id}")
    public Response deleteActivity(@PathVariable int id){
        try {
            return activityService.delete(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "BAD REQUEST\n");
        }
    }
}
