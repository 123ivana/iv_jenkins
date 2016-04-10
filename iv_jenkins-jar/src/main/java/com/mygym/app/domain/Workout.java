package com.mygym.app.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * User: MARKO
 * Date: 9/17/13
 * Time: 11:06 PM
 */

@Entity
@Table(name="workout")
public class Workout {

    @Id
    @Column(name="workout_id")
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name="workout_type_id")
    private WorkoutType workoutType;

    @Column(name="value")
    private Double value; //distance in kilometres or weight in kilograms

    @ManyToMany(mappedBy="workouts")
    private Set<Training> trainings = new HashSet<Training>();

    public Workout() {
    }

    public Workout(WorkoutType workoutType, Double value) {
        this.workoutType = workoutType;
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public WorkoutType getWorkoutType() {
        return workoutType;
    }

    public void setWorkoutType(WorkoutType workoutType) {
        this.workoutType = workoutType;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Set<Training> getTrainings() {
        return trainings;
    }

    public void setTrainings(Set<Training> trainings) {
        this.trainings = trainings;
    }
}
