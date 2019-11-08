package com.example.adminresources.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "user_exercise")
public class UserExercise implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @OneToOne(targetEntity = User.class)
    private User user;

    @OneToOne(targetEntity = Exercise.class)
    private Exercise exercise;

    @Column(name = "exercise_value")
    private Integer exerciseValue;

    @Column(name = "link_for_approve")
    private String linkForApprove;

    @NotNull
    @Column(name = "isApproved")
    private Boolean isApproved;

    @Column(name = "created_date")
    private LocalDate createdDate;

    public UserExercise() {
    }

    public UserExercise(User user, Exercise exercise, Integer exerciseValue) {
        this.user = user;
        this.exercise = exercise;
        this.exerciseValue = exerciseValue;
        this.linkForApprove = null;
        this.isApproved = false;
        this.createdDate = LocalDate.now();
    }
}
