package com.recipesharing.app.service;

import java.util.List;
import java.util.Optional;

import com.recipesharing.app.dto.RecipeResponseDTO;
import com.recipesharing.app.entity.RecipeEntity;

public interface RecipeService {
	List<RecipeEntity> getAllRecipes();
	Optional<RecipeEntity> getRecipeById(Long id);
	RecipeEntity createRecipe(RecipeEntity recipe);
	RecipeEntity updateRecipe(RecipeEntity recipe);
	String deleteRecipe(Long id);
	RecipeResponseDTO getDetailedRecipeById(Long id);
}
