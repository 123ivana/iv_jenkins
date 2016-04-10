package com.mygym.app.domain;

import javax.persistence.*;
import java.util.Set;

/**
 * User: MARKO
 * Date: 9/17/13
 * Time: 11:03 PM
 */
@Entity
@Table(name="workout_type")
public class WorkoutType {

    @Id
    @Column(name="workout_type_id")
    @GeneratedValue
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="icon_url")
    private String iconUrl;

    @OneToMany(mappedBy="workoutType")
    private Set<Workout> workouts;

    public WorkoutType() {
    }

    public WorkoutType(String name, String iconUrl) {
        this.name = name;
        this.iconUrl = iconUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public Set<Workout> getWorkouts() {
        return workouts;
    }

    public void setWorkouts(Set<Workout> workouts) {
        this.workouts = workouts;
    }
}
