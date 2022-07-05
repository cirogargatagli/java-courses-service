package com.ajsw.javacoursesservice.models.entities;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "reserve")
@NoArgsConstructor
public class Reserve {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_reserve")
    private int idReserve;
    @Basic
    @Column(name = "created_at", nullable = false)
    private Timestamp createdAt = new Timestamp(System.currentTimeMillis());

    @ManyToOne
    @JoinColumn(
            name = "id_course",
            referencedColumnName = "id_course",
            foreignKey = @ForeignKey(
                    name = "fk_reserve_course",
                    foreignKeyDefinition = "FOREIGN KEY (id_course)\n" +
                            "        REFERENCES course (id_course) MATCH SIMPLE\n" +
                            "        ON UPDATE CASCADE\n" +
                            "        ON DELETE CASCADE",
                    value = ConstraintMode.CONSTRAINT
            )
    )
    private Course course;

    @ManyToOne
    @JoinColumn(
            name = "id_client",
            referencedColumnName = "id_person",
            foreignKey = @ForeignKey(
                    name = "fk_reserve_client",
                    foreignKeyDefinition = "FOREIGN KEY (id_client)\n" +
                            "        REFERENCES client (id_person) MATCH SIMPLE\n" +
                            "        ON UPDATE CASCADE\n" +
                            "        ON DELETE CASCADE",
                    value = ConstraintMode.CONSTRAINT
            )
    )
    private Client client;

    @OneToOne
    @JoinColumn(name = "id_payment")
    private Payment payment;

    public Reserve(Course course, Client client, Payment payment) {
        this.payment = payment;
        this.client = client;
        this.course = course;
    }

    public Reserve(int idReserve, Course course, Client client, Payment payment) {
        this.idReserve = idReserve;
        this.payment = payment;
        this.client = client;
        this.course = course;
    }

    public int getIdReserve() {
        return idReserve;
    }

    public void setIdReserve(int idReserve) {
        this.idReserve = idReserve;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
