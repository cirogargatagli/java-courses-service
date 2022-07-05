package com.ajsw.javacoursesservice.repositories;

import com.ajsw.javacoursesservice.models.entities.Reserve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IReserveRepository extends JpaRepository<Reserve, Integer> {
    List<Reserve> findReservesByClient_IdPerson(int id);
}

