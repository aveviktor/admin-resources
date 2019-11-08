package com.example.adminresources.bean;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class NewExerciseCommand {

    @NotBlank(message = "exercise is not selected")
    public String name;

    public String description;

    public Integer min;

    public Integer med;

    public Integer max;

    public void setMin(String min) {
        this.min = Integer.valueOf(min);
    }

    public void setMed(String med) {
        this.med = Integer.valueOf(med);
    }

    public void setMax(String max) {
        this.max = Integer.valueOf(max);
    }
}
