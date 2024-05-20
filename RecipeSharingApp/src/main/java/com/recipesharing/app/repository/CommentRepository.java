package com.recipesharing.app.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.recipesharing.app.entity.CommentEntity;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Long> {
	boolean existsByIdAndUser_Id(Long commentId, Long userId);
	
	List<CommentEntity> findByRecipeId(Long recipeId);
}
