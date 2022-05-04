package com.ajsw.javacoursesservice.models.entities;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Objects;

@Entity
@Table(name = "payment", schema = "public", catalog = "d9sp9r36nrg2j2")
public class PaymentEntity {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentEntity that = (PaymentEntity) o;
        return idPayment == that.idPayment && Objects.equals(amount, that.amount) && Objects.equals(paymentMethod, that.paymentMethod);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPayment, amount, paymentMethod);
    }
}
