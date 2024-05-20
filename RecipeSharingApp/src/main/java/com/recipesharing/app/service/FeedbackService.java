package com.recipesharing.app.service;

public interface FeedbackService {

    boolean likeRecipe(Long userId, Long recipeId);

    boolean unlikeRecipe(Long userId, Long recipeId);

    boolean isRecipeLikedByUser(Long userId, Long recipeId);

    void addComment(Long userId, Long recipeId, String commentText);

    void updateComment(Long commentId, String newCommentText);

    void deleteComment(Long commentId);

    boolean isCommentedByUser(Long userId, Long commentId);

    void addRating(Long userId, Long recipeId, int rating);

    void updateRating(Long ratingId, int newRating);

    void deleteRating(Long ratingId);

    boolean isRatedByUser(Long userId, Long ratingId);

    void addReview(Long userId, Long recipeId, String reviewText);

    void updateReview(Long reviewId, String newReviewText);

    void deleteReview(Long reviewId);

    boolean isReviewedByUser(Long userId, Long reviewId);
}

