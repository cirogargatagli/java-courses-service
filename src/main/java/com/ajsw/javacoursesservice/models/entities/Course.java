package com.ajsw.javacoursesservice.models.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Time;
import java.util.List;

@Entity
@Table(name = "course")
public class Course implements Serializable {
    @Serial
    private static final long serialVersionUID = 6641056045967898825L;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_course")
    private int idCourse;
    @Basic
    @Column(name = "start_time")
    private Time startTime;
    @Basic
    @Column(name = "end_time")
    private Time endTime;
    @Basic
    @Column(name = "price")
    private BigInteger price;
    @Basic
    @Column(name = "tittle")
    private String tittle;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "imageURL")
    private String imageURL;
    @Basic
    @Column(name = "capacity")
    private int capacity;

    @ManyToOne
    @JoinColumn(
            name = "id_instructor",
            referencedColumnName = "id_person",
            foreignKey = @ForeignKey(
                    name = "fk_course_instructor",
                    foreignKeyDefinition = "FOREIGN KEY (id_instructor)\n" +
                            "        REFERENCES instructor (id_person) MATCH SIMPLE\n" +
                            "        ON UPDATE CASCADE\n" +
                            "        ON DELETE CASCADE",
                    value = ConstraintMode.CONSTRAINT
            )
    )
    private Instructor instructor;

    @OneToOne
    @JoinColumn(name = "id_activity")
    private Activity activity;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_address")
    private Address address;

    @ManyToOne
    @JoinColumn(
            name = "id_day",
            referencedColumnName = "id_day",
            foreignKey = @ForeignKey(
                    name = "fk_course_day",
                    foreignKeyDefinition = "FOREIGN KEY (id_day)\n" +
                            "        REFERENCES day (id_day) MATCH SIMPLE\n" +
                            "        ON UPDATE CASCADE\n" +
                            "        ON DELETE CASCADE",
                    value = ConstraintMode.CONSTRAINT
            )
    )
    private Day day;

    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id_reserve"
    )
    @JsonIdentityReference(alwaysAsId = true)
    @OneToMany(mappedBy = "course", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reserve> reserves;

    public Course() {
    }

    public Course(int idCourse) {
        this.idCourse = idCourse;
    }

    public Course(Time startTime, Time endTime, BigInteger price, String tittle, String description, String imageURL,
                  int capacity, Day day, Instructor instructor, Activity activity, Address address) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.price = price;
        this.tittle = tittle;
        this.description = description;
        this.imageURL = imageURL;
        this.capacity = capacity;
        this.day = day;
        this.instructor = instructor;
        this.activity = activity;
        this.address = address;
    }

    public int getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(int idCourse) {
        this.idCourse = idCourse;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public BigInteger getPrice() {
        return price;
    }

    public void setPrice(BigInteger price) {
        this.price = price;
    }

    public String getTittle() { return tittle; }

    public void setTittle(String tittle) { this.tittle = tittle; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public String getImageURL() { return imageURL; }

    public void setImageURL(String imageURL) { this.imageURL = imageURL; }

    public int getCapacity() { return capacity; }

    public void setCapacity(int capacity) { this.capacity = capacity; }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Day getDay() { return day; }

    public void setDay(Day day) { this.day = day; }
}
