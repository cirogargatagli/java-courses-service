package com.ajsw.javacoursesservice.models.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Entity
@PrimaryKeyJoinColumn(name = "id_person", foreignKey = @ForeignKey(name = "fk_instructor_person"))
@OnDelete(action = OnDeleteAction.CASCADE)
@Table(name = "instructor")
public class Instructor extends Person implements Serializable {
    @Serial
    private static final long serialVersionUID = -1355425955634433304L;
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "idCourse"
    )
    @JsonIdentityReference(alwaysAsId = true)
    @OneToMany(mappedBy = "instructor", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Course> courses;

    public Instructor() {

    }

    public Instructor(String firstName, String lastName, String phone, Account account) {
        super(firstName, lastName, phone, account);
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

}
