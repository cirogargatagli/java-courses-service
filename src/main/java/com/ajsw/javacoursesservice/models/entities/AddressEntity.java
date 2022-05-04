package com.ajsw.javacoursesservice.models.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "address", schema = "public", catalog = "d9sp9r36nrg2j2")
public class AddressEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_address")
    private int idAddress;
    @Basic
    @Column(name = "street")
    private String street;
    @Basic
    @Column(name = "number_house")
    private String numberHouse;
    @Basic
    @Column(name = "id_locality")
    private Integer idLocality;

    public int getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(int idAddress) {
        this.idAddress = idAddress;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumberHouse() {
        return numberHouse;
    }

    public void setNumberHouse(String numberHouse) {
        this.numberHouse = numberHouse;
    }

    public Integer getIdLocality() {
        return idLocality;
    }

    public void setIdLocality(Integer idLocality) {
        this.idLocality = idLocality;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressEntity that = (AddressEntity) o;
        return idAddress == that.idAddress && Objects.equals(street, that.street) && Objects.equals(numberHouse, that.numberHouse) && Objects.equals(idLocality, that.idLocality);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAddress, street, numberHouse, idLocality);
    }
}
