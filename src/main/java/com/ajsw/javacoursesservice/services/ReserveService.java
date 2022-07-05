package com.ajsw.javacoursesservice.services;

import com.ajsw.javacoursesservice.models.dtos.request.PaymentMPRequest;
import com.ajsw.javacoursesservice.models.dtos.request.ReservePaymentRequest;
import com.ajsw.javacoursesservice.models.dtos.request.ReserveRequest;
import com.ajsw.javacoursesservice.models.dtos.response.EntityCreatedResponse;
import com.ajsw.javacoursesservice.models.dtos.response.ReserveResponseDto;
import com.ajsw.javacoursesservice.models.dtos.response.Response;
import com.ajsw.javacoursesservice.models.entities.Reserve;
import com.ajsw.javacoursesservice.models.mappers.ListMapper;
import com.ajsw.javacoursesservice.repositories.IReserveRepository;
import com.ajsw.javacoursesservice.util.ReserveUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReserveService {
    private final IReserveRepository reserveRepository;
    private final PaymentService paymentService;
    private final MailService mailService;
    private final ReserveUtil reserveUtil;
    private final String nameEntity = "Reserve";
    private final ModelMapper mapper;
    private final ListMapper listMapper;

    @Autowired
    public ReserveService(IReserveRepository reserveRepository, PaymentService paymentService, MailService mailService, ReserveUtil reserveUtil, ModelMapper mapper, ListMapper listMapper){
        this.reserveRepository = reserveRepository;
        this.paymentService = paymentService;
        this.mailService = mailService;
        this.reserveUtil = reserveUtil;
        this.mapper = mapper;
        this.listMapper = listMapper;
    }

    public Response saveReserveAndPayment(ReservePaymentRequest reserveRequest){

        Response paymentResponse = paymentService.payWithMP(mapper.map(reserveRequest.paymentDto, PaymentMPRequest.class));

        if(paymentResponse.statusCode == 201){

            Reserve reserve = reserveUtil.createReserve(reserveRequest, ((EntityCreatedResponse)paymentResponse).getId());
            
            Reserve reserveCreated = reserveRepository.save(reserve);
            //Falta enviar email. Iría acá

            return new EntityCreatedResponse(reserveCreated.getIdReserve(), nameEntity);
        } else {
            return new Response(paymentResponse.statusCode, "The reservation could not be registered. ".concat(paymentResponse.message));
        }
    }

    public Response updateReserve(ReserveRequest reserveRequest){

        Reserve reserve = reserveUtil.updateReserve(reserveRequest);

        Reserve reserveCreated = reserveRepository.save(reserve);

        return new EntityCreatedResponse(reserveCreated.getIdReserve(), nameEntity);
    }

    public ReserveResponseDto getReserveById(int id){
        return mapper.map(reserveRepository.findById(id).get(), ReserveResponseDto.class);
    }

    public List<ReserveResponseDto> getReservesByUser(int id){
        return listMapper.mapList(reserveRepository.findReservesByClient_IdPerson(id), ReserveResponseDto.class);
    }

    public Response deleteReserve(int id) {
        reserveRepository.deleteById(id);
        return new Response(200, "Reserve deleted successfully");
    }
}

