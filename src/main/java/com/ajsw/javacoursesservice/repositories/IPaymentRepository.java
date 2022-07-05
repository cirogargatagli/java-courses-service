package com.ajsw.javacoursesservice.repositories;

import com.ajsw.javacoursesservice.models.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPaymentRepository extends JpaRepository<Payment, Integer> {
}
