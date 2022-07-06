package com.ajsw.javacoursesservice.controllers;

import com.ajsw.javacoursesservice.models.dtos.request.ReservePaymentRequest;
import com.ajsw.javacoursesservice.models.dtos.request.ReserveRequest;
import com.ajsw.javacoursesservice.models.dtos.response.ReserveResponseDto;
import com.ajsw.javacoursesservice.models.dtos.response.Response;
import com.ajsw.javacoursesservice.services.ReserveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/reserves")
public class ReserveController {

    private final ReserveService reserveService;

    @Autowired
    public ReserveController(ReserveService _reserveService){
        reserveService = _reserveService;
    }

    @PostMapping()
    public Response createReserveAndPayment(@Validated @RequestBody ReservePaymentRequest reservePaymentRequest){
        try {
            return reserveService.saveReserveAndPayment(reservePaymentRequest);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "BAD REQUEST\n");
        }
    }

    @PutMapping()
    public Response updateReserve(@Validated @RequestBody ReserveRequest reserveRequest) {
        try {
            return reserveService.updateReserve(reserveRequest);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "BAD REQUEST\n");
        }
    }

    @DeleteMapping("/{id}")
    public Response deleteReserve(@PathVariable int id){
        try {
            return reserveService.deleteReserve(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "BAD REQUEST\n");
        }
    }

    @GetMapping("/{id}")
    public ReserveResponseDto getReserveById(@PathVariable int id){
        try {
            return reserveService.getReserveById(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "BAD REQUEST\n");
        }
    }

    @GetMapping("/users/{idUser}")
    public List<ReserveResponseDto> getReservesByUser(@PathVariable int idUser){
        try {
            return reserveService.getReservesByUser(idUser);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "BAD REQUEST\n");
        }
    }
}