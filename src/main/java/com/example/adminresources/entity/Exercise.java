package com.example.adminresources.entity;

import com.example.adminresources.bean.NewExerciseCommand;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "exercise")
public class Exercise implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "min_range")
    private Integer minRange;

    @Column(name = "med_range")
    private Integer medRange;

    @Column(name = "max_range")
    private Integer maxRange;

    public Exercise() {
    }

    public Exercise(NewExerciseCommand command) {
        this.name = command.name;
        this.description = command.description;
        this.minRange = command.min;
        this.medRange = command.med;
        this.maxRange = command.max;
    }

    public Exercise(String name, String description, Integer minRange, Integer medRange, Integer maxRange) {
        this.name = name;
        this.description = description;
        this.minRange = minRange;
        this.medRange = medRange;
        this.maxRange = maxRange;
    }
}
