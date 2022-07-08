package com.ajsw.javacoursesservice.models.mappers;

import com.ajsw.javacoursesservice.models.dtos.response.*;
import com.ajsw.javacoursesservice.models.entities.Course;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CourseMapper {

    public List<CourseDto> mapCoursesToCoursesDto(List<Course> courses){
        List<CourseDto> coursesDto = new ArrayList<CourseDto>();
        for (Course course: courses) {
            CourseDto courseDto = new CourseDto();
            courseDto.idCourse = course.getIdCourse();
            courseDto.startTime = course.getStartTime();
            courseDto.endTime = course.getEndTime();
            courseDto.tittle = course.getTittle();
            courseDto.imageURL = course.getImageURL();
            courseDto.day = new DayResponseDto();
            courseDto.day.idDay = course.getDay().getIdDay();
            courseDto.day.nameDay = course.getDay().getNameDay();
            courseDto.capacity = course.getCapacity();
            courseDto.reservesCount = course.getReserves() == null ? 0 : course.getReserves().size();
            coursesDto.add(courseDto);
        }
        return coursesDto;
    }

    public List<FullCourseDto> mapCoursesToFullCoursesDto(List<Course> courses){
        List<FullCourseDto> fullCoursesDto = new ArrayList<FullCourseDto>();
        for (Course course: courses) {
            fullCoursesDto.add(mapCourseToFullCourseDto(course));
        }
        return fullCoursesDto;
    }

    public FullCourseDto mapCourseToFullCourseDto(Course course){
        FullCourseDto fullCourseDto = new FullCourseDto();
        fullCourseDto.idCourse = course.getIdCourse();
        fullCourseDto.startTime = course.getStartTime();
        fullCourseDto.endTime = course.getEndTime();
        fullCourseDto.price = course.getPrice();
        fullCourseDto.tittle = course.getTittle();
        fullCourseDto.description = course.getDescription();
        fullCourseDto.imageURL = course.getImageURL();
        fullCourseDto.capacity = course.getCapacity();
        fullCourseDto.instructor = new InstructorDto();
        fullCourseDto.instructor.idInstructor = course.getInstructor().getIdPerson();
        fullCourseDto.instructor.firstName = course.getInstructor().getFirstName();
        fullCourseDto.instructor.lastName = course.getInstructor().getLastName();
        fullCourseDto.activity = new ActivityDto();
        fullCourseDto.activity.idActivity = course.getActivity().getIdActivity();
        fullCourseDto.activity.description = course.getActivity().getDescription();
        fullCourseDto.address = new AddressDto();
        fullCourseDto.address.street = course.getAddress().getStreet();
        fullCourseDto.address.numberHouse = course.getAddress().getNumberHouse();
        fullCourseDto.address.locality = new LocalityDto();
        fullCourseDto.address.locality.idLocality = course.getAddress().getLocality().getIdLocality();
        fullCourseDto.address.locality.name = course.getAddress().getLocality().getName();
        fullCourseDto.address.locality.postalCode = course.getAddress().getLocality().getPostalCode();
        fullCourseDto.day = new DayResponseDto();
        fullCourseDto.day.idDay = course.getDay().getIdDay();
        fullCourseDto.day.nameDay = course.getDay().getNameDay();
        fullCourseDto.reservesCount = course.getReserves() == null ? 0 : course.getReserves().size();
        return fullCourseDto;
    }
}
