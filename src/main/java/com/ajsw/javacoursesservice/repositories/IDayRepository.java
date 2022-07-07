package com.ajsw.javacoursesservice.repositories;

import com.ajsw.javacoursesservice.models.entities.Day;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDayRepository extends JpaRepository<Day, Integer> {
}
