package com.recipesharing.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.recipesharing.app.entity.RecipeEntity;


@Repository

public interface RecipeRepository extends JpaRepository<RecipeEntity, Long>{

}
