package com.ajsw.javacoursesservice.repositories;

import com.ajsw.javacoursesservice.models.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICourseRepository extends JpaRepository<Course, Integer> {
    List<Course> getCoursesByAddress_Locality_IdLocality(Integer idLocality);
}