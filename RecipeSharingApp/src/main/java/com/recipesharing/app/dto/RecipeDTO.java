package com.recipesharing.app.dto;


public class RecipeDTO {
    private Long recipeId;
    private String title;
    private String description;
    private String ingredients;
    private String preperationSteps;
    private String category;
    private String cuisine;
    private String difficulty;
	public Long getRecipeId() {
		return recipeId;
	}
	public void setRecipeId(Long recipeId) {
		this.recipeId = recipeId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getIngredients() {
		return ingredients;
	}
	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}
	public String getPreperationSteps() {
		return preperationSteps;
	}
	public void setPreperationSteps(String preperationSteps) {
		this.preperationSteps = preperationSteps;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getCuisine() {
		return cuisine;
	}
	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}
	public String getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}
    
    

 
}

