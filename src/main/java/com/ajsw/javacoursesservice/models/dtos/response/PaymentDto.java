package com.ajsw.javacoursesservice.models.dtos.response;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.math.BigDecimal;

public class PaymentDto {

    @Getter
    @Setter
    public String firstName;

    @Getter
    @Setter
    public BigDecimal transactionAmount;

    @Getter
    @Setter
    public String cardToken;

    @Getter
    @Setter
    public String paymentMethodId;

    @Getter
    @Setter
    public String description;

    @Getter
    @Setter
    public String identificationType;

    @Getter
    @Setter
    public String identificationNumber;

    @Getter
    @Setter
    @Min(1)
    @Max(12)
    public int installments;
}
