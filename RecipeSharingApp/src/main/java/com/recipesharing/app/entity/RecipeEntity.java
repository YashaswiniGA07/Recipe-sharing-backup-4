package com.recipesharing.app.entity;

import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@jakarta.persistence.Entity
@Table(name= "recipe")
public class RecipeEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="title")
	private String title;
	
	@Column(name="description")
	private String description;
	
	@Column(name="ingredients")
	private String ingredients;
	
	@Column(name="preperationSteps")
	private String preperationSteps;
	
	@Column(name="category")
	private String category;
	
	@Column(name="cuisine")
	private String cuisine;
	
	@Column(name="difficulty")
	private String difficulty;
	
	@Column(name = "created_at", updatable = false)
	private LocalDateTime createdAt;

	@Column(name = "updated_at")
	private LocalDateTime updatedAt;
	
	@OneToMany(mappedBy = "recipe", cascade = CascadeType.REMOVE) // Cascade remove operation only
    private Set<LikeEntity> likes;
	
	public RecipeEntity() {
		super();
	}
	
	public RecipeEntity(Long id, String title, String description, String ingredients, String preperationSteps,
			String category, String cuisine, String difficulty) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.ingredients = ingredients;
		this.preperationSteps = preperationSteps;
		this.category = category;
		this.cuisine = cuisine;
		this.difficulty = difficulty;
	}
	
	@PrePersist
	protected void onCreate() {
		this.createdAt = LocalDateTime.now();
		this.updatedAt = LocalDateTime.now();
	}

	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = LocalDateTime.now();
	}

	public Long getRecipeId() {
		return id;
	}

	public void setRecipeId(Long id) {
		this.id = id;
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
	
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
	
}
