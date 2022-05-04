package com.ajsw.javacoursesservice.models.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "reserve", schema = "public", catalog = "d9sp9r36nrg2j2")
public class ReserveEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_reserve")
    private int idReserve;
    @Basic
    @Column(name = "created_at")
    private Date createdAt;
    @Basic
    @Column(name = "id_course")
    private Integer idCourse;
    @Basic
    @Column(name = "id_client")
    private Integer idClient;
    @Basic
    @Column(name = "id_payment")
    private Integer idPayment;

    public int getIdReserve() {
        return idReserve;
    }

    public void setIdReserve(int idReserve) {
        this.idReserve = idReserve;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(Integer idCourse) {
        this.idCourse = idCourse;
    }

    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    public Integer getIdPayment() {
        return idPayment;
    }

    public void setIdPayment(Integer idPayment) {
        this.idPayment = idPayment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReserveEntity that = (ReserveEntity) o;
        return idReserve == that.idReserve && Objects.equals(createdAt, that.createdAt) && Objects.equals(idCourse, that.idCourse) && Objects.equals(idClient, that.idClient) && Objects.equals(idPayment, that.idPayment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idReserve, createdAt, idCourse, idClient, idPayment);
    }
}
