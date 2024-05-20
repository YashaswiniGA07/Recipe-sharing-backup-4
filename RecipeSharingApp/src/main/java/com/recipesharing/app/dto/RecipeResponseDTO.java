package com.recipesharing.app.dto;

import java.util.List;

public class RecipeResponseDTO {
    private RecipeDTO recipe;
    private int likeCount;
    private List<CommentDTO> comments;
    private List<ReviewDTO> reviews;
    private List<RatingDTO> ratings;
	public RecipeDTO getRecipe() {
		return recipe;
	}
	public void setRecipe(RecipeDTO recipe) {
		this.recipe = recipe;
	}
	public int getLikeCount() {
		return likeCount;
	}
	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}
	public List<CommentDTO> getComments() {
		return comments;
	}
	public void setComments(List<CommentDTO> comments) {
		this.comments = comments;
	}
	public List<ReviewDTO> getReviews() {
		return reviews;
	}
	public void setReviews(List<ReviewDTO> reviews) {
		this.reviews = reviews;
	}
	public List<RatingDTO> getRatings() {
		return ratings;
	}
	public void setRatings(List<RatingDTO> ratings) {
		this.ratings = ratings;
	}

    
}
