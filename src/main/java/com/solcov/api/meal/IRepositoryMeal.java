package com.solcov.api.meal;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableAutoConfiguration
public interface IRepositoryMeal extends JpaRepository<Meal, Long> {

    List<Meal> findByType(String type);

}
