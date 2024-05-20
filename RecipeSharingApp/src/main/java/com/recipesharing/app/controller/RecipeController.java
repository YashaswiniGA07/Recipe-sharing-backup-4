package com.recipesharing.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recipesharing.app.dto.RecipeResponseDTO;
import com.recipesharing.app.entity.RecipeEntity;
import com.recipesharing.app.service.RecipeService;
import com.recipesharing.app.serviceimpl.RecipeServiceImpl;

@RestController
@RequestMapping("/recipe")
public class RecipeController {
	private final RecipeService recipeSer;
	public RecipeController(RecipeService recipeSer)
	{
		this.recipeSer=recipeSer;
	}
	
	@GetMapping
	public List<RecipeEntity> getAllRecipes()
	{
		return recipeSer.getAllRecipes();
	}
	
//	@GetMapping("/{id}")
//	public Optional<RecipeEntity> getRecipeById(@PathVariable("id") Long id)
//	{
//		return recipeSer.getRecipeById(id);
//	}
	
	@GetMapping("/{id}")
    public RecipeResponseDTO getRecipeById(@PathVariable("id") Long id) {
         // Cast to use the specific implementation method
		return recipeSer.getDetailedRecipeById(id);
    }
	
	@PostMapping
	public RecipeEntity createRecipe(@RequestBody RecipeEntity recipe)
	{
		return recipeSer.createRecipe(recipe);
	}
	
	@PutMapping("/{id}")
	public RecipeEntity updateRecipee(@PathVariable("id") Long id, @RequestBody RecipeEntity recipe)
	{
		recipe.setRecipeId(id);
		return recipeSer.updateRecipe(recipe);
	}
	
	@DeleteMapping("/{id}")
	public String deleteRecipe(@PathVariable("id") Long id)
	{
		return recipeSer.deleteRecipe(id);
	}
	

}

