package com.ajsw.javacoursesservice.controllers;

import com.ajsw.javacoursesservice.models.dtos.request.ActivityRequest;
import com.ajsw.javacoursesservice.models.dtos.request.UpdateCourseRequest;
import com.ajsw.javacoursesservice.models.dtos.response.Response;
import com.ajsw.javacoursesservice.models.entities.Activity;
import com.ajsw.javacoursesservice.models.enums.RoleEnum;
import com.ajsw.javacoursesservice.services.ActivityService;
import com.ajsw.javacoursesservice.services.JwtService;
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
    private final JwtService jwtService;

    @Autowired
    public ActivityController(ActivityService activityService, JwtService jwtService){
        this.activityService = activityService;
        this.jwtService = jwtService;

    }

    @GetMapping()
    public List<Activity> getActivities(){  return  activityService.getAll(); }

    @PostMapping()
    public Response createActivity(@RequestHeader(value = "Authorization") String authToken, @Validated @RequestBody ActivityRequest activityRequest){
        try {
            jwtService.validateToken(authToken, RoleEnum.Admin.name());
            return activityService.save(activityRequest);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "BAD REQUEST\n");
        }
    }

    @DeleteMapping(value = "/{id}")
    public Response deleteActivity(@RequestHeader(value = "Authorization") String authToken, @PathVariable int id){
        try {
            jwtService.validateToken(authToken, RoleEnum.Admin.name());
            return activityService.delete(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "BAD REQUEST\n");
        }
    }
}
