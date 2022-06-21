package com.ajsw.javacoursesservice.models.entities;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "activity")
@NoArgsConstructor
public class Activity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_activity")
    private int idActivity;
    @Basic
    @Column(name = "description")
    private String description;

    @Basic
    @Column(name = "image_url")
    private String imageURL;

    public Activity(int idActivity) { this.idActivity = idActivity; }

    public Activity() {

    }

    public int getIdActivity() {
        return idActivity;
    }

    public void setIdActivity(int idActivity) {
        this.idActivity = idActivity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageURL() { return imageURL; }

    public void setImageURL(String imageURL) { this.imageURL = imageURL; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Activity activity = (Activity) o;
        return idActivity == activity.idActivity && Objects.equals(description, activity.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idActivity, description);
    }
}
