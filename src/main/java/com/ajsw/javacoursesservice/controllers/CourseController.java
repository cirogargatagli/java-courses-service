package com.ajsw.javacoursesservice.controllers;

import com.ajsw.javacoursesservice.models.dtos.request.CourseRequest;
import com.ajsw.javacoursesservice.models.dtos.response.CourseDto;
import com.ajsw.javacoursesservice.models.dtos.response.FullCourseDto;
import com.ajsw.javacoursesservice.services.CourseService;
import com.ajsw.javacoursesservice.models.dtos.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService){
        this.courseService = courseService;
    }

    @PostMapping()
    public Response createCourse(@Validated @RequestBody CourseRequest courseRequest){
        try{
            return courseService.save(courseRequest);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error registering the client .\n");
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public FullCourseDto getCourse(@RequestParam(required = false, defaultValue = "0") int id) {
        return courseService.getById(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<CourseDto> getCourses(
            @RequestParam(required = false, defaultValue = "0") Integer idLocality,
            @RequestParam(required = false, defaultValue = "0") Integer idActivity
    ){
        return courseService.getCourses(idLocality, idActivity);
    }
}