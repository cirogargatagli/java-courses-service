package com.ajsw.javacoursesservice.services;

import com.ajsw.javacoursesservice.models.dtos.response.CourseDto;
import com.ajsw.javacoursesservice.models.entities.Course;
import com.ajsw.javacoursesservice.models.mappers.ListMapper;
import com.ajsw.javacoursesservice.repositories.ICourseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    private final ICourseRepository courseRepository;
    private final ModelMapper modelMapper;
    private final ListMapper listMapper;

    @Autowired
    public CourseService(ICourseRepository courseRepository, ModelMapper modelMapper, ListMapper listMapper){
        this.courseRepository = courseRepository;
        this.modelMapper = modelMapper;
        this.listMapper = listMapper;
    }

    public Course save(Course courseRequest){
        return courseRepository.save(courseRequest);
    }

    public CourseDto getById(Integer id){
        return modelMapper.map(courseRepository.findById(id).get(), CourseDto.class);
    }

    public List<CourseDto> getAll(){
        List<Course> courses = courseRepository.findAll();
        return listMapper.mapList(courses, CourseDto.class);
    }

    public List<CourseDto> getCoursesByIdLocality(Integer idLocality){
        return listMapper.mapList(courseRepository.getCoursesByAddress_Locality_IdLocality(idLocality), CourseDto.class);
    }
}
