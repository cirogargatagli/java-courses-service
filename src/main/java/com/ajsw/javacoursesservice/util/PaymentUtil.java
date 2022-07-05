package com.ajsw.javacoursesservice.util;

import com.ajsw.javacoursesservice.models.entities.Payment;
import com.mercadopago.client.payment.PaymentCreateRequest;
import org.springframework.stereotype.Component;

@Component
public class PaymentUtil {
    public Payment createPayment(PaymentCreateRequest paymentCreateRequest, boolean isProcessed){
        return new Payment(
            paymentCreateRequest.getTransactionAmount().toBigInteger(),
            paymentCreateRequest.getPaymentMethodId(),
            isProcessed
        );
    }
}
