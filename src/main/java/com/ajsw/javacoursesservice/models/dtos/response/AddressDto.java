package com.ajsw.javacoursesservice.models.dtos.response;

import lombok.Getter;
import lombok.Setter;

public class AddressDto {
    @Getter
    @Setter
    public String street;

    @Getter
    @Setter
    public String numberHouse;

    @Getter
    @Setter
    public LocalityDto locality;
}
