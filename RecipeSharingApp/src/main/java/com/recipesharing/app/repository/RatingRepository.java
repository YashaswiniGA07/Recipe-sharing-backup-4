package com.recipesharing.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.recipesharing.app.entity.RatingEntity;

@Repository
public interface RatingRepository extends JpaRepository<RatingEntity, Long> {
	boolean existsByIdAndUser_Id(Long ratingId, Long userId);
	
	List<RatingEntity> findByRecipeId(Long recipeId);
}
