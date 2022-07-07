package com.ajsw.javacoursesservice.models.dtos.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class AddressRequest {
    @Getter
    @Setter
    @NotNull(message = "Street may not be null")
    private String street;

    @Getter
    @Setter
    @NotBlank(message = "Number may not be null")
    private String numberHouse;

    @Getter
    @Setter
    @Min(value = 1, message = "A locality must be inserted")
    private int idLocality;
}
