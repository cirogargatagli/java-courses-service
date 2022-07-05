package com.ajsw.javacoursesservice.models.dtos.request;

import com.ajsw.javacoursesservice.models.dtos.response.PaymentDto;
import lombok.Getter;
import lombok.Setter;

public class ReservePaymentRequest {
    @Getter
    @Setter
    public int idCourse;

    @Getter
    @Setter
    public int idClient;

    @Getter
    @Setter
    public PaymentDto paymentDto;
}
