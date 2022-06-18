package com.ajsw.javacoursesservice.services;

import com.ajsw.javacoursesservice.models.dtos.response.CourseDto;
import com.ajsw.javacoursesservice.models.entities.Activity;
import com.ajsw.javacoursesservice.models.entities.Course;
import com.ajsw.javacoursesservice.models.mappers.ListMapper;
import com.ajsw.javacoursesservice.repositories.IActivityRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityService {
    private final IActivityRepository activityRepository;
    private final ModelMapper modelMapper;
    private final ListMapper listMapper;

    @Autowired
    public ActivityService(IActivityRepository activityRepository, ModelMapper modelMapper, ListMapper listMapper){
        this.activityRepository = activityRepository;
        this.modelMapper = modelMapper;
        this.listMapper = listMapper;
    }

    public List<Activity> getAll(){
        return activityRepository.findAll();
    }
}
