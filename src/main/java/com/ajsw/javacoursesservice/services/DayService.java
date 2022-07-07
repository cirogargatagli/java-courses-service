package com.ajsw.javacoursesservice.services;

import com.ajsw.javacoursesservice.models.dtos.response.DayResponseDto;
import com.ajsw.javacoursesservice.models.mappers.ListMapper;
import com.ajsw.javacoursesservice.repositories.IDayRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DayService {
    private final IDayRepository dayRepository;
    private final ModelMapper modelMapper;
    private final ListMapper listMapper;

    @Autowired
    public DayService(IDayRepository dayRepository, ModelMapper modelMapper, ListMapper listMapper){
        this.dayRepository = dayRepository;
        this.modelMapper = modelMapper;
        this.listMapper = listMapper;
    }

    public List<DayResponseDto> getAll(){
        return listMapper.mapList(dayRepository.findAll(), DayResponseDto.class);
    }
}
