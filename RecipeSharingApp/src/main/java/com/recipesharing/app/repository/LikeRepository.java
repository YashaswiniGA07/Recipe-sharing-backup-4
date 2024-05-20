package com.recipesharing.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.recipesharing.app.entity.LikeEntity;
@Repository
public interface LikeRepository extends JpaRepository<LikeEntity, Long> {

    boolean existsByUserIdAndRecipeId(Long userId, Long recipeId);

    void deleteByUserIdAndRecipeId(Long userId, Long recipeId);
    
    int countByRecipeId(Long recipeId);
}
