package com.ajsw.javacoursesservice.util;

import com.ajsw.javacoursesservice.models.dtos.request.CourseRequest;
import com.ajsw.javacoursesservice.models.entities.*;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CourseUtil {
    protected final ModelMapper modelMapper;

    public CourseUtil(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Course createCourse(CourseRequest request){
        Address address = modelMapper.map(request.address, Address.class);
        address.setLocality(new Locality(request.address.getIdLocality()));
        address.setIdAddress(0);

        return new Course(
          request.startTime,
          request.endTime,
          request.price,
          request.tittle,
          request.description,
          request.imageURL,
          new Instructor(request.idInstructor),
          new Activity(request.idActivity),
            address
        );
    }
}
