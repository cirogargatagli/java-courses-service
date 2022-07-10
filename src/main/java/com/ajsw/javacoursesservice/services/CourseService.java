package com.ajsw.javacoursesservice.services;

import com.ajsw.javacoursesservice.models.dtos.request.CourseRequest;
import com.ajsw.javacoursesservice.models.dtos.request.UpdateCourseRequest;
import com.ajsw.javacoursesservice.models.dtos.response.CourseDto;
import com.ajsw.javacoursesservice.models.dtos.response.FullCourseDto;
import com.ajsw.javacoursesservice.models.dtos.response.EntityCreatedResponse;
import com.ajsw.javacoursesservice.models.dtos.response.Response;
import com.ajsw.javacoursesservice.models.entities.*;
import com.ajsw.javacoursesservice.models.mappers.CourseMapper;
import com.ajsw.javacoursesservice.models.mappers.ListMapper;
import com.ajsw.javacoursesservice.repositories.ICourseRepository;
import com.ajsw.javacoursesservice.util.CourseUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

@Service
public class CourseService {
    private final ICourseRepository courseRepository;
    private final ModelMapper modelMapper;
    private final CourseMapper courseMapper;
    private final CourseUtil courseUtil;
    private final String nameEntity = "Course";

    @Autowired
    public CourseService(ICourseRepository courseRepository, ModelMapper modelMapper, CourseMapper courseMapper, CourseUtil courseUtil){
        this.courseRepository = courseRepository;
        this.modelMapper = modelMapper;
        this.courseMapper = courseMapper;
        this.courseUtil = courseUtil;
    }

    public Response save(CourseRequest courseRequest){
        Course course = courseUtil.createCourse(courseRequest);
        Course newCourse = courseRepository.save(course);
        return new EntityCreatedResponse(newCourse.getIdCourse(), nameEntity);
    }

    public Response delete(int id){
        courseRepository.deleteById(id);
        return new Response(200, "Delete successfully");
    }

    public Response updateCourse(UpdateCourseRequest courseRequest){
        Course course = courseRepository.findById(courseRequest.id).get();
        if(!Objects.equals(course.getAddress().getStreet(), courseRequest.getAddress().getStreet())){
            course.getAddress().setStreet(courseRequest.getAddress().getStreet());
        }
        if(!Objects.equals(course.getAddress().getNumberHouse(), courseRequest.getAddress().getNumberHouse())){
            course.getAddress().setNumberHouse(courseRequest.getAddress().getNumberHouse());
        }
        if(!Objects.equals(course.getAddress().getLocality().getIdLocality(), courseRequest.getAddress().getIdLocality())){
            course.getAddress().setLocality(new Locality(courseRequest.getAddress().getIdLocality()));
        }
        if(!Objects.equals(course.getInstructor().getIdPerson(), courseRequest.getIdInstructor())){
            course.setInstructor(new Instructor(courseRequest.getIdInstructor()));
        }
        if(!Objects.equals(course.getDay().getIdDay(), courseRequest.getIdDay())){
            course.setDay(new Day(courseRequest.getIdDay()));
        }
        if(!Objects.equals(course.getActivity().getIdActivity(), courseRequest.getIdActivity())){
            course.setActivity(new Activity(courseRequest.getIdActivity()));
        }
        if(!Objects.equals(course.getActivity().getIdActivity(), courseRequest.getIdActivity())){
            course.setActivity(new Activity(courseRequest.getIdActivity()));
        }
        if(!Objects.equals(course.getTittle(), courseRequest.getTittle())){
            course.setTittle(courseRequest.getTittle());
        }
        if(!Objects.equals(course.getPrice(), courseRequest.getPrice())){
            course.setPrice(courseRequest.getPrice());
        }
        if(!Objects.equals(course.getCapacity(), courseRequest.getCapacity())){
            course.setCapacity(courseRequest.getCapacity());
        }
        if(!Objects.equals(course.getDescription(), courseRequest.getDescription())){
            course.setDescription(courseRequest.getDescription());
        }
        if(!Objects.equals(course.getEndTime(), courseRequest.getEndTime())){
            course.setEndTime(courseRequest.getEndTime());
        }
        if(!Objects.equals(course.getImageURL(), courseRequest.getImageURL())){
            course.setImageURL(courseRequest.getImageURL());
        }
        if(!Objects.equals(course.getStartTime(), courseRequest.getStartTime())){
            course.setStartTime(courseRequest.getStartTime());
        }
        return new EntityCreatedResponse(courseRepository.save(course).getIdCourse(), nameEntity);
    }

    public FullCourseDto getById(Integer id){
        return courseMapper.mapCourseToFullCourseDto(courseRepository.findById(id).get());
    }

    public List<CourseDto> getAll(){
       return courseMapper.mapCoursesToCoursesDto(courseRepository.findAll());
    }

    public List<CourseDto> getCourses(Integer idLocality, Integer idActivity){
        if(idLocality <= 0 && idActivity <= 0){
            return this.getAll();
        } else if(idActivity <= 0){
            return this.getCoursesByIdLocality(idLocality);
        } else if(idLocality <= 0){
            return this.getCoursesByIdActivity(idActivity);
        } else {
            return this.getCoursesByLocalityAndActivity(idLocality, idActivity);
        }
    }

    public List<FullCourseDto> getFullCourses(){
        return courseMapper.mapCoursesToFullCoursesDto(courseRepository.findAll());
    }

    public List<CourseDto> getCoursesByIdLocality(Integer idLocality){
        return courseMapper.mapCoursesToCoursesDto(courseRepository.getCoursesByAddress_Locality_IdLocality(idLocality));
    }

    public List<CourseDto> getCoursesByIdActivity(Integer idActivity){
        return courseMapper.mapCoursesToCoursesDto(courseRepository.getCoursesByActivity_IdActivity(idActivity));
    }

    public List<CourseDto> getCoursesByLocalityAndActivity(Integer idLocality, Integer idActivity){
        return courseMapper.mapCoursesToCoursesDto(courseRepository.findCoursesByAddress_Locality_IdLocalityAndActivity_IdActivity(idLocality, idActivity));
    }

    public List<FullCourseDto> getCoursesByIdInstructor(Integer idInstructor){
        return courseMapper.mapCoursesToFullCoursesDto(courseRepository.getCoursesByInstructor_IdPerson(idInstructor));
    }

    public List<CourseDto> mostReserved(){
        List<CourseDto> allCourses = getAll();
        allCourses.sort((c1, c2) -> c2.reservesCount - c1.reservesCount);
        return allCourses.size() > 3 ? allCourses.subList(0,3) : allCourses;
    }
}
