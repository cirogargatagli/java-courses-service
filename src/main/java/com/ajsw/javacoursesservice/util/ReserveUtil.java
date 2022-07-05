package com.ajsw.javacoursesservice.util;

import com.ajsw.javacoursesservice.models.dtos.request.ReservePaymentRequest;
import com.ajsw.javacoursesservice.models.dtos.request.ReserveRequest;
import com.ajsw.javacoursesservice.models.entities.Client;
import com.ajsw.javacoursesservice.models.entities.Course;
import com.ajsw.javacoursesservice.models.entities.Payment;
import com.ajsw.javacoursesservice.models.entities.Reserve;
import org.springframework.stereotype.Component;


@Component
public class ReserveUtil {

    public Reserve updateReserve(ReserveRequest request){
        return new Reserve(
                request.getIdReserve(),
                new Course(request.getIdCourse()),
                new Client(request.getIdClient()),
                new Payment(request.getIdPayment())
        );
    }

    public Reserve createReserve(ReservePaymentRequest reserveRequest, int idPayment){
        return new Reserve(
                new Course(reserveRequest.idCourse),
                new Client(reserveRequest.idClient),
                new Payment(idPayment)
        );
    }
}

