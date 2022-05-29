package com.ajsw.javacoursesservice.models.dtos.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
public class Response {
    @Getter
    @Setter
    public int statusCode;

    @Getter
    @Setter
    public String message;

    public Response() {

    }

    public Response(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }
}
