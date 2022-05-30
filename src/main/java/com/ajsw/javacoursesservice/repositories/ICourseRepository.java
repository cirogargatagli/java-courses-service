package com.ajsw.javacoursesservice.repositories;

import com.ajsw.javacoursesservice.models.entities.Course;
import io.swagger.models.auth.In;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICourseRepository extends JpaRepository<Course, Integer> {
    List<Course> getCoursesByAddress_Locality_IdLocality(Integer idLocality);

    List<Course> findCoursesByAddress_LocalityPostalCode(String postalCode);

    List<Course> getCoursesByAddress_Locality_IdLocalityAndAddress_LocalityPostalCode(Integer idLocality, String postalCode);
}