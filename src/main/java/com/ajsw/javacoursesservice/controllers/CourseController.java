package com.ajsw.javacoursesservice.controllers;

import com.ajsw.javacoursesservice.models.dtos.request.CourseRequest;
import com.ajsw.javacoursesservice.models.dtos.request.UpdateCourseRequest;
import com.ajsw.javacoursesservice.models.dtos.response.CourseDto;
import com.ajsw.javacoursesservice.models.dtos.response.FullCourseDto;
import com.ajsw.javacoursesservice.models.enums.RoleEnum;
import com.ajsw.javacoursesservice.services.CourseService;
import com.ajsw.javacoursesservice.models.dtos.response.Response;
import com.ajsw.javacoursesservice.services.JwtService;
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
    private final JwtService jwtService;

    @Autowired
    public CourseController(CourseService courseService, JwtService jwtService){
        this.courseService = courseService;
        this.jwtService = jwtService;
    }

    @PostMapping()
    public Response createCourse(@RequestHeader(value = "Authorization") String authToken, @Validated @RequestBody CourseRequest courseRequest){
        try{
            jwtService.validateToken(authToken, RoleEnum.Admin.name());
            return courseService.save(courseRequest);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error create course .\n");
        }
    }

    @DeleteMapping(value="/{idCourse}")
    public Response deleteCourse(@RequestHeader(value = "Authorization") String authToken, @PathVariable int idCourse){
        try{
            jwtService.validateToken(authToken, RoleEnum.Admin.name());
            return courseService.delete(idCourse);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error delete course .\n");
        }
    }

    @PutMapping()
    public Response updateCourse(@RequestHeader(value = "Authorization") String authToken, @Validated @RequestBody UpdateCourseRequest courseRequest){
        try{
            jwtService.validateToken(authToken, RoleEnum.Admin.name());
            return courseService.updateCourse(courseRequest);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error update course .\n");
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

    @RequestMapping(value = "/most-reserved", method = RequestMethod.GET)
    public List<CourseDto> getMostReserved(){
        return courseService.mostReserved();
    }

    @RequestMapping(value = "/full", method = RequestMethod.GET)
    public List<FullCourseDto> getFullCourses(){
        return courseService.getFullCourses();
    }

    @RequestMapping(value ="/instructor/{idInstructor}",method = RequestMethod.GET)
    public List<FullCourseDto> getCoursesByIdInstructor(@RequestHeader(value = "Authorization") String authToken, @PathVariable int idInstructor){
        try {
            jwtService.validateToken(authToken, RoleEnum.Instructor.name());
            return courseService.getCoursesByIdInstructor(idInstructor);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "BAD REQUEST\n");
        }
    }

}