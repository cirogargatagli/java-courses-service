package com.ajsw.javacoursesservice.repositories;

import com.ajsw.javacoursesservice.models.entities.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IActivityRepository extends JpaRepository<Activity, Integer> {
}
