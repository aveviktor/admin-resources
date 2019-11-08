package com.example.adminresources.repository;

import com.example.adminresources.entity.achieve.Achieve;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AchieveRepository extends CrudRepository<Achieve, Long> {

}
