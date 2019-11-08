package com.example.adminresources.repository;

import com.example.adminresources.entity.UserExercise;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserExerciseRepository extends CrudRepository<UserExercise, Long> {

    List<UserExercise> findAll();

    List<UserExercise> findAllByIsApprovedFalse();
}
