package com.recipesharing.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.recipesharing.app.service.FeedbackService;


@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @PostMapping("/like")
    public ResponseEntity<?> likeRecipe(@RequestParam("userId") Long userId, @RequestParam("recipeId") Long recipeId) {
        boolean success = feedbackService.likeRecipe(userId, recipeId);
        if (success) {
            return ResponseEntity.ok("Recipe liked successfully.");
        } else {
            return ResponseEntity.badRequest().body("Recipe already liked by the user.");
        }
    }

    @PostMapping("/unlike")
    public ResponseEntity<?> unlikeRecipe(@RequestParam("userId") Long userId, @RequestParam("recipeId") Long recipeId) {
        boolean success = feedbackService.unlikeRecipe(userId, recipeId);
        if (success) {
            return ResponseEntity.ok("Recipe unliked successfully.");
        } else {
            return ResponseEntity.badRequest().body("Recipe not liked by the user.");
        }
    }

    @GetMapping("/check-like")
    public ResponseEntity<?> checkIfLikedByUser(@RequestParam("userId") Long userId, @RequestParam("recipeId") Long recipeId) {
        boolean liked = feedbackService.isRecipeLikedByUser(userId, recipeId);
        return ResponseEntity.ok(liked);
    }
    

    @PostMapping("/comment")
    public ResponseEntity<?> addComment(@RequestParam("userId") Long userId, @RequestParam("recipeId") Long recipeId, @RequestParam("commentText") String commentText) {
        feedbackService.addComment(userId, recipeId, commentText);
        return ResponseEntity.ok("Comment added successfully.");
    }

    @PutMapping("/comment")
    public ResponseEntity<?> updateComment(@RequestParam("commentId") Long commentId, @RequestParam("newCommentText") String newCommentText) {
        feedbackService.updateComment(commentId, newCommentText);
        return ResponseEntity.ok("Comment updated successfully.");
    }

    @DeleteMapping("/comment")
    public ResponseEntity<?> deleteComment(@RequestParam("commentId") Long commentId) {
        feedbackService.deleteComment(commentId);
        return ResponseEntity.ok("Comment deleted successfully.");
    }
    
    @GetMapping("/check-comment")
    public ResponseEntity<?> isCommentBelongsToUser(@RequestParam("userId") Long userId, @RequestParam("commentId") Long commentId) {
            boolean belongsToUser = feedbackService.isCommentedByUser(userId, commentId);
            return ResponseEntity.ok(belongsToUser);
    }


    @PostMapping("/rating")
    public ResponseEntity<?> addRating(@RequestParam("userId") Long userId, @RequestParam("recipeId") Long recipeId, @RequestParam("rating") int rating) {
        feedbackService.addRating(userId, recipeId, rating);
        return ResponseEntity.ok("Rating added successfully.");
    }

    @PutMapping("/rating")
    public ResponseEntity<?> updateRating(@RequestParam("ratingId") Long ratingId, @RequestParam("newRating") int newRating) {
        feedbackService.updateRating(ratingId, newRating);
        return ResponseEntity.ok("Rating updated successfully.");
    }

    @DeleteMapping("/rating")
    public ResponseEntity<?> deleteRating(@RequestParam("ratingId") Long ratingId) {
        feedbackService.deleteRating(ratingId);
        return ResponseEntity.ok("Rating deleted successfully.");
    }
    
    @GetMapping("/check-rating")
    public ResponseEntity<?> isRatingBelongsToUser(@RequestParam("userId") Long userId, @RequestParam("ratingId") Long ratingId) {
            boolean belongsToUser = feedbackService.isRatedByUser(userId, ratingId);
            return ResponseEntity.ok(belongsToUser);
    }

    @PostMapping("/review")
    public ResponseEntity<?> addReview(@RequestParam("userId") Long userId, @RequestParam("recipeId") Long recipeId, @RequestParam("reviewText") String reviewText) {
        feedbackService.addReview(userId, recipeId, reviewText);
        return ResponseEntity.ok("Review added successfully.");
    }

    @PutMapping("/review")
    public ResponseEntity<?> updateReview(@RequestParam("reviewId") Long reviewId, @RequestParam("newReviewText") String newReviewText) {
        feedbackService.updateReview(reviewId, newReviewText);
        return ResponseEntity.ok("Review updated successfully.");
    }

    @DeleteMapping("/review")
    public ResponseEntity<?> deleteReview(@RequestParam("reviewId") Long reviewId) {
        feedbackService.deleteReview(reviewId);
        return ResponseEntity.ok("Review deleted successfully.");
    }
    
    @GetMapping("/check-review")
    public ResponseEntity<?> isReviewBelongsToUser(@RequestParam("userId") Long userId, @RequestParam("reviewId") Long reviewId) {
            boolean belongsToUser = feedbackService.isReviewedByUser(userId, reviewId);
            return ResponseEntity.ok(belongsToUser);
    
    }
}

