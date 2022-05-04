package com.ajsw.javacoursesservice.models.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "client", schema = "public", catalog = "d9sp9r36nrg2j2")
public class ClientEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_person")
    private int idPerson;
    @Basic
    @Column(name = "first_name")
    private String firstName;
    @Basic
    @Column(name = "last_name")
    private String lastName;
    @Basic
    @Column(name = "phone")
    private String phone;
    @Basic
    @Column(name = "id_account")
    private Integer idAccount;
    @Basic
    @Column(name = "id_address")
    private Integer idAddress;

    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(Integer idAccount) {
        this.idAccount = idAccount;
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
        ClientEntity that = (ClientEntity) o;
        return idPerson == that.idPerson && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(phone, that.phone) && Objects.equals(idAccount, that.idAccount) && Objects.equals(idAddress, that.idAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPerson, firstName, lastName, phone, idAccount, idAddress);
    }
}
