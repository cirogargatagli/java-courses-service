package com.ajsw.javacoursesservice.models.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "role")
public class Role implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_role")
    private int idRole;

    @Basic
    @Column(name = "description")
    private String description;

    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
