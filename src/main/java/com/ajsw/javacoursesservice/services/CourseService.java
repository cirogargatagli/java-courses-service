package com.ajsw.javacoursesservice.services;

import com.ajsw.javacoursesservice.models.dtos.request.CourseRequest;
import com.ajsw.javacoursesservice.models.dtos.request.UpdateCourseRequest;
import com.ajsw.javacoursesservice.models.dtos.response.CourseDto;
import com.ajsw.javacoursesservice.models.dtos.response.FullCourseDto;
import com.ajsw.javacoursesservice.models.dtos.response.EntityCreatedResponse;
import com.ajsw.javacoursesservice.models.dtos.response.Response;
import com.ajsw.javacoursesservice.models.entities.*;
import com.ajsw.javacoursesservice.models.mappers.ListMapper;
import com.ajsw.javacoursesservice.repositories.ICourseRepository;
import com.ajsw.javacoursesservice.util.CourseUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

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
        Course course = courseUtil.createCourse(courseRequest);
        Course newCourse = courseRepository.save(course);
        return new EntityCreatedResponse(newCourse.getIdCourse(), nameEntity);
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
        return modelMapper.map(courseRepository.findById(id).get(), FullCourseDto.class);
    }

    public List<CourseDto> getAll(){
        List<Course> courses = courseRepository.findAll();
        return listMapper.mapList(courses, CourseDto.class);
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
        return listMapper.mapList(courseRepository.findAll(), FullCourseDto.class);
    }

    public List<CourseDto> getCoursesByIdLocality(Integer idLocality){
        return listMapper.mapList(courseRepository.getCoursesByAddress_Locality_IdLocality(idLocality), CourseDto.class);
    }

    public List<CourseDto> getCoursesByIdActivity(Integer idActivity){
        return listMapper.mapList(courseRepository.getCoursesByActivity_IdActivity(idActivity), CourseDto.class);
    }

    public List<CourseDto> getCoursesByLocalityAndActivity(Integer idLocality, Integer idActivity){
        return listMapper.mapList(courseRepository.findCoursesByAddress_Locality_IdLocalityAndActivity_IdActivity(idLocality, idActivity), CourseDto.class);
    }

    public List<CourseDto> getCoursesByIdInstructor(Integer idInstructor){
        return listMapper.mapList(courseRepository.getCoursesByInstructor_IdPerson(idInstructor), CourseDto.class);
    }
}
