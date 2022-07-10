package com.ajsw.javacoursesservice.services;

import com.ajsw.javacoursesservice.models.dtos.request.PaymentMPRequest;
import com.ajsw.javacoursesservice.models.dtos.response.EntityCreatedResponse;
import com.ajsw.javacoursesservice.models.dtos.response.Response;
import com.ajsw.javacoursesservice.repositories.IPaymentRepository;
import com.ajsw.javacoursesservice.util.PaymentUtil;
import com.mercadopago.MercadoPagoConfig;
import com.mercadopago.client.common.IdentificationRequest;
import com.mercadopago.client.payment.PaymentClient;
import com.mercadopago.client.payment.PaymentCreateRequest;
import com.mercadopago.client.payment.PaymentPayerRequest;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.payment.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    private final IPaymentRepository paymentRepository;
    private final PaymentUtil paymentUtil;
    private final String nameEntity = "Payment";

    static final boolean IS_PROCESSED_OK = true;
    static final boolean NOT_PROCESSED = false;

    @Value("${payment-email-test}")
    private String emailTest;

//    @Value("${mp-access-token}")
//    private String accessToken;

    public PaymentService(IPaymentRepository paymentRepository, PaymentUtil paymentUtil) {
        this.paymentRepository = paymentRepository;
        this.paymentUtil = paymentUtil;
    }

    public Response payWithMP(PaymentMPRequest paymentMPRequest){
        MercadoPagoConfig.setAccessToken("TEST-1326476364225901-071001-5f9c18e98828279e17fcddc4f46e5723-1157887152");

        PaymentClient client = new PaymentClient();

        PaymentCreateRequest createRequest =
                PaymentCreateRequest.builder()
                        .token(paymentMPRequest.getCardToken())
                        .transactionAmount(paymentMPRequest.getTransactionAmount())
                        .description(paymentMPRequest.getDescription())
                        .installments(paymentMPRequest.getInstallments())
                        .paymentMethodId(paymentMPRequest.getPaymentMethodId())
                        .payer(
                                PaymentPayerRequest.builder()
                                        .email(emailTest)
                                        .firstName(paymentMPRequest.getFirstName())
                                        .identification(
                                                IdentificationRequest.builder()
                                                        .type(paymentMPRequest.getIdentificationType())
                                                        .number(paymentMPRequest.getIdentificationNumber())
                                                        .build())
                                        .build())
                        .build();

        try {
            Payment payment = client.create(createRequest);
            System.out.println(payment);
            com.ajsw.javacoursesservice.models.entities.Payment newPayment =
                this.savePayment(paymentUtil.createPayment(createRequest, IS_PROCESSED_OK));
            return new EntityCreatedResponse(newPayment.getIdPayment(), nameEntity);
        } catch (MPApiException ex) {
            System.out.printf(
                    "MercadoPago Error. Status: %s, Content: %s%n",
                    ex.getApiResponse().getStatusCode(), ex.getApiResponse().getContent());
            com.ajsw.javacoursesservice.models.entities.Payment newPayment =
                    this.savePayment(paymentUtil.createPayment(createRequest, NOT_PROCESSED));
            return new Response(500, "Error con la API");
        } catch (MPException ex) {
            ex.printStackTrace();
            com.ajsw.javacoursesservice.models.entities.Payment newPayment =
                    this.savePayment(paymentUtil.createPayment(createRequest, NOT_PROCESSED));
            return new Response(400, "Error con el pago");
        }
    }

    public com.ajsw.javacoursesservice.models.entities.Payment savePayment(com.ajsw.javacoursesservice.models.entities.Payment payment){
        //Devuelvo el objeto Payment para quedarme con el id
        return paymentRepository.save(payment);
    }
}
