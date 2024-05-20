package com.recipesharing.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.recipesharing.app.entity.ReviewEntity;

@Repository
public interface ReviewRepository extends JpaRepository<ReviewEntity, Long> {
	boolean existsByIdAndUser_Id(Long reviewId, Long userId);
	
	List<ReviewEntity> findByRecipeId(Long recipeId);
}

