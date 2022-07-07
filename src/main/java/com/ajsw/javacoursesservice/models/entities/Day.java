package com.ajsw.javacoursesservice.models.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Table(name = "day")
public class Day {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_day")
    @Getter
    @Setter
    private int idDay;

    @Basic
    @Column(name = "name_day")
    @Getter
    @Setter
    private String nameDay;

    @OneToMany(mappedBy = "day", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Course> courses;

    public Day(int idDay){ this.idDay = idDay; }
}
