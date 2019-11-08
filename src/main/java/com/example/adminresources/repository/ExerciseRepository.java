package com.example.adminresources.repository;

import com.example.adminresources.entity.Exercise;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExerciseRepository extends CrudRepository<Exercise, Long> {

    List<Exercise> findAll();

    Exercise getExerciseById(Long id);

    Exercise getExerciseByName(String exerciseName);
}
