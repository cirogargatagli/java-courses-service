package com.ajsw.javacoursesservice.util;

import com.ajsw.javacoursesservice.models.entities.Reserve;
import org.springframework.stereotype.Component;

@Component
public class MailUtil {

    public String createTextMessage(Reserve reserve){
        String text = String.join(System.lineSeparator(),
                "RERSERVATION:",
                "Your course reservation was successfully registered.",
                "Course: ".concat(reserve.getCourse().getTittle()),
                reserve.getCourse().getAddress().toString());
        return text;
    }
}
