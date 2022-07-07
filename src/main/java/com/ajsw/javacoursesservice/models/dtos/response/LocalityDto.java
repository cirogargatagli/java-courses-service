package com.ajsw.javacoursesservice.models.dtos.response;

import lombok.Getter;
import lombok.Setter;

public class LocalityDto {
    @Getter
    @Setter
    public int idLocality;
    @Getter
    @Setter
    public String name;

    @Getter
    @Setter
    public String postalCode;
}
