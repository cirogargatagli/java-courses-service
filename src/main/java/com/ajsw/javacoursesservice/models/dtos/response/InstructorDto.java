package com.ajsw.javacoursesservice.models.dtos.response;

import lombok.Getter;
import lombok.Setter;

public class InstructorDto {
    @Getter
    @Setter
    public int idInstructor;
    @Getter
    @Setter
    public String firstName;
    @Getter
    @Setter
    public String lastName;
}
