package com.mygym.app.domain;

import com.mygym.app.domain.enums.TrainingType;

import javax.persistence.*;
import java.util.*;

/**
 * User: MARKO
 * Date: 9/17/13
 * Time: 11:11 PM
 */
@Entity
@Table(name="training")
public class Training {

    @Id
    @Column(name="training_id")
    @GeneratedValue
    private Long id;

    @Column(name="training_type_id")
    @Enumerated(EnumType.ORDINAL)
    private TrainingType trainingType;

    @Column(name="duration")
    private Integer duration; // in minutes

    @Column(name="training_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date trainingDate;

    @ManyToMany(cascade={CascadeType.ALL})
    @JoinTable(name="training_workout",
            joinColumns={@JoinColumn(name="training_id")},
            inverseJoinColumns={@JoinColumn(name="workout_id")})
    private Set<Workout> workouts = new HashSet<Workout>();

    public Training() {
    }

    public Training(TrainingType trainingType, Integer duration, Date trainingDate, Set<Workout> workouts) {
        this.trainingType = trainingType;
        this.duration = duration;
        this.trainingDate = trainingDate;
        this.workouts = workouts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TrainingType getTrainingType() {
        return trainingType;
    }

    public void setTrainingType(TrainingType trainingType) {
        this.trainingType = trainingType;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Date getTrainingDate() {
        return trainingDate;
    }

    public void setTrainingDate(Date trainingDate) {
        this.trainingDate = trainingDate;
    }

    public Set<Workout> getWorkouts() {
        return workouts;
    }

    public void setWorkouts(Set<Workout> workouts) {
        this.workouts = workouts;
    }
}
