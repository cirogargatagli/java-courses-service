package com.ajsw.javacoursesservice.services;

import com.ajsw.javacoursesservice.models.dtos.request.CourseRequest;
import com.ajsw.javacoursesservice.models.dtos.response.CourseDto;
import com.ajsw.javacoursesservice.models.dtos.response.EntityCreatedResponse;
import com.ajsw.javacoursesservice.models.dtos.response.Response;
import com.ajsw.javacoursesservice.models.entities.Course;
import com.ajsw.javacoursesservice.models.mappers.ListMapper;
import com.ajsw.javacoursesservice.repositories.ICourseRepository;
import com.ajsw.javacoursesservice.util.CourseUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    private final ICourseRepository courseRepository;
    private final ModelMapper modelMapper;
    private final ListMapper listMapper;
    private final CourseUtil courseUtil;
    private final String nameEntity = "Course";

    @Autowired
    public CourseService(ICourseRepository courseRepository, ModelMapper modelMapper, ListMapper listMapper, CourseUtil courseUtil){
        this.courseRepository = courseRepository;
        this.modelMapper = modelMapper;
        this.listMapper = listMapper;
        this.courseUtil = courseUtil;
    }

    public Response save(CourseRequest courseRequest){
        Course newCourse = courseRepository.save(courseUtil.createCourse(courseRequest));
        return new EntityCreatedResponse(newCourse.getIdCourse(), nameEntity);
    }

    public CourseDto getById(Integer id){
        return modelMapper.map(courseRepository.findById(id).get(), CourseDto.class);
    }

    public List<CourseDto> getAll(){
        List<Course> courses = courseRepository.findAll();
        return listMapper.mapList(courses, CourseDto.class);
    }

    public List<CourseDto> getCourses(Integer idLocality){
        if(idLocality <= 0){
            return this.getAll();
        } else {
            return this.getCoursesByIdLocality(idLocality);
        }
    }

    public List<CourseDto> getCoursesByIdLocality(Integer idLocality){
        return listMapper.mapList(courseRepository.getCoursesByAddress_Locality_IdLocality(idLocality), CourseDto.class);
    }
}
