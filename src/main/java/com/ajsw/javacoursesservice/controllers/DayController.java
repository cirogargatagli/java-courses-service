package com.ajsw.javacoursesservice.controllers;

import com.ajsw.javacoursesservice.models.dtos.response.DayResponseDto;
import com.ajsw.javacoursesservice.services.DayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/days")
public class DayController {
    private final DayService dayService;

    @Autowired
    public DayController(DayService dayService){
        this.dayService = dayService;
    }

    @GetMapping()
    public List<DayResponseDto> getAllDays(){ return dayService.getAll(); }
}
