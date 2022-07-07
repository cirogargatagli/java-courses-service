package com.ajsw.javacoursesservice.models.dtos.request;

import lombok.Getter;
import lombok.Setter;

public class UpdateCourseRequest extends CourseRequest{
    @Getter
    @Setter
    public int id;
}
