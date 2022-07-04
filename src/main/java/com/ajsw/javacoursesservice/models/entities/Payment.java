package com.ajsw.javacoursesservice.models.entities;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Objects;

@Entity
@Table(name = "payment")
public class Payment {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_payment")
    private int idPayment;

    @Basic
    @Column(name = "amount")
    private BigInteger amount;

    @Basic
    @Column(name = "payment_method")
    private String paymentMethod;

    @Basic
    @Column(name = "is_processed")
    private boolean isProcessed;

    public int getIdPayment() {
        return idPayment;
    }

    public void setIdPayment(int idPayment) {
        this.idPayment = idPayment;
    }

    public BigInteger getAmount() {
        return amount;
    }

    public void setAmount(BigInteger amount) {
        this.amount = amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public boolean isProcessed() { return isProcessed; }

    public void setProcessed(boolean processed) { isProcessed = processed; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return idPayment == payment.idPayment && Objects.equals(amount, payment.amount) && Objects.equals(paymentMethod, payment.paymentMethod) && Objects.equals(isProcessed, payment.isProcessed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPayment, amount, paymentMethod, isProcessed);
    }
}
