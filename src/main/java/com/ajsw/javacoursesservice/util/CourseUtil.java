package com.ajsw.javacoursesservice.util;

import com.ajsw.javacoursesservice.models.dtos.request.CourseRequest;
import com.ajsw.javacoursesservice.models.entities.Activity;
import com.ajsw.javacoursesservice.models.entities.Address;
import com.ajsw.javacoursesservice.models.entities.Course;
import com.ajsw.javacoursesservice.models.entities.Instructor;

public class CourseUtil {
    public Course createCourse(CourseRequest request){
        return new Course(
          request.startTime,
          request.endTime,
          request.price,
          new Instructor(request.idInstructor),
          new Activity(request.idActivity),
          new Address(request.idAddress)
        );
    }
}
