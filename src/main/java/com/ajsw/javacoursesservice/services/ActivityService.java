package com.ajsw.javacoursesservice.services;

import com.ajsw.javacoursesservice.models.dtos.request.ActivityRequest;
import com.ajsw.javacoursesservice.models.dtos.response.EntityCreatedResponse;
import com.ajsw.javacoursesservice.models.dtos.response.Response;
import com.ajsw.javacoursesservice.models.entities.Activity;
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

    private final String nameEntity = "Activity";

    @Autowired
    public ActivityService(IActivityRepository activityRepository, ModelMapper modelMapper, ListMapper listMapper){
        this.activityRepository = activityRepository;
        this.modelMapper = modelMapper;
        this.listMapper = listMapper;
    }

    public List<Activity> getAll(){
        return activityRepository.findAll();
    }

    public Response save(ActivityRequest activityRequest){
        Activity activity = new Activity(activityRequest.description);
        return new EntityCreatedResponse(activityRepository.save(activity).getIdActivity(), nameEntity);
    }

    public Response delete(int id){
        activityRepository.deleteById(id);
        return new Response(200, "Activity deleted successfully");
    }
}
