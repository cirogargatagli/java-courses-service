package com.ajsw.javacoursesservice.controllers;

import com.ajsw.javacoursesservice.models.dtos.response.CourseDto;
import com.ajsw.javacoursesservice.models.entities.Course;
import com.ajsw.javacoursesservice.services.CourseService;
import io.swagger.models.Response;
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
    public Response createCourse(@Validated @RequestBody Course courseRequest){
        try{
//            return courseService.save(courseRequest);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error registering the client .\n");
        }
        return null;
    }

    @RequestMapping(value = "/",  method = RequestMethod.GET)
    public List<CourseDto> getAll(){
        return courseService.getAll();
    }

    @RequestMapping(method = RequestMethod.GET)
    public CourseDto getCourse(@RequestParam(required = false, defaultValue = "0") int id) {
        return courseService.getById(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<CourseDto> getCoursesByLocality(@RequestParam(defaultValue = "0") int idLocality){
        return courseService.getCoursesByIdLocality(idLocality);
    }
}