package com.ajsw.javacoursesservice.models.entities;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "course", schema = "public", catalog = "d9sp9r36nrg2j2")
public class CourseEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_course")
    private int idCourse;
    @Basic
    @Column(name = "start_time")
    private Date startTime;
    @Basic
    @Column(name = "end_time")
    private Date endTime;
    @Basic
    @Column(name = "price")
    private BigInteger price;
    @Basic
    @Column(name = "id_instructor")
    private Integer idInstructor;
    @Basic
    @Column(name = "id_activity")
    private Integer idActivity;
    @Basic
    @Column(name = "id_address")
    private Integer idAddress;

    public int getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(int idCourse) {
        this.idCourse = idCourse;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public BigInteger getPrice() {
        return price;
    }

    public void setPrice(BigInteger price) {
        this.price = price;
    }

    public Integer getIdInstructor() {
        return idInstructor;
    }

    public void setIdInstructor(Integer idInstructor) {
        this.idInstructor = idInstructor;
    }

    public Integer getIdActivity() {
        return idActivity;
    }

    public void setIdActivity(Integer idActivity) {
        this.idActivity = idActivity;
    }

    public Integer getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(Integer idAddress) {
        this.idAddress = idAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseEntity that = (CourseEntity) o;
        return idCourse == that.idCourse && Objects.equals(startTime, that.startTime) && Objects.equals(endTime, that.endTime) && Objects.equals(price, that.price) && Objects.equals(idInstructor, that.idInstructor) && Objects.equals(idActivity, that.idActivity) && Objects.equals(idAddress, that.idAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCourse, startTime, endTime, price, idInstructor, idActivity, idAddress);
    }
}
