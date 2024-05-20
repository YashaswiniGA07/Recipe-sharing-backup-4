package com.recipesharing.app.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recipesharing.app.entity.CommentEntity;
import com.recipesharing.app.entity.LikeEntity;
import com.recipesharing.app.entity.RatingEntity;
import com.recipesharing.app.entity.RecipeEntity;
import com.recipesharing.app.entity.ReviewEntity;
import com.recipesharing.app.entity.UserEntity;
import com.recipesharing.app.repository.CommentRepository;
import com.recipesharing.app.repository.LikeRepository;
import com.recipesharing.app.repository.RatingRepository;
import com.recipesharing.app.repository.RecipeRepository;
import com.recipesharing.app.repository.ReviewRepository;
import com.recipesharing.app.repository.UserRepository;
import com.recipesharing.app.service.FeedbackService;

import jakarta.transaction.Transactional;


@Service
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired
    private LikeRepository likeRepository;

    @Autowired
    private UserRepository userRepository; 

    @Autowired
    private RecipeRepository recipeRepository;
    
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private RatingRepository ratingRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    @Transactional
    public boolean likeRecipe(Long userId, Long recipeId) {
        if (!likeRepository.existsByUserIdAndRecipeId(userId, recipeId)) {
            UserEntity user = userRepository.findById(userId)
                    .orElseThrow(() -> new RuntimeException("User not found"));
            RecipeEntity recipe = recipeRepository.findById(recipeId)
                    .orElseThrow(() -> new RuntimeException("Recipe not found"));

            LikeEntity like = new LikeEntity();
            like.setUser(user);
            like.setRecipe(recipe);
            likeRepository.save(like);
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public boolean unlikeRecipe(Long userId, Long recipeId) {
        if (likeRepository.existsByUserIdAndRecipeId(userId, recipeId)) {
            likeRepository.deleteByUserIdAndRecipeId(userId, recipeId);
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public boolean isRecipeLikedByUser(Long userId, Long recipeId) {
        return likeRepository.existsByUserIdAndRecipeId(userId, recipeId);
    }
    
 // Comment methods
    @Override
    @Transactional
    public void addComment(Long userId, Long recipeId, String commentText) {
        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        RecipeEntity recipe = recipeRepository.findById(recipeId)
                .orElseThrow(() -> new RuntimeException("Recipe not found"));

        CommentEntity comment = new CommentEntity();
        comment.setUser(user);
        comment.setRecipe(recipe);
        comment.setCommentText(commentText);
        commentRepository.save(comment);
    }

    @Override
    @Transactional
    public void updateComment(Long commentId, String newCommentText) {
        CommentEntity comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new RuntimeException("Comment not found"));
        comment.setCommentText(newCommentText);
        commentRepository.save(comment);
    }

    @Override
    @Transactional
    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }

    @Override
    @Transactional
    public boolean isCommentedByUser(Long userId, Long commentId) {
        return commentRepository.existsByIdAndUser_Id(commentId, userId);
    }

    // Rating methods
    @Override
    @Transactional
    public void addRating(Long userId, Long recipeId, int rating) {
        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        RecipeEntity recipe = recipeRepository.findById(recipeId)
                .orElseThrow(() -> new RuntimeException("Recipe not found"));

        RatingEntity ratingEntity = new RatingEntity();
        ratingEntity.setUser(user);
        ratingEntity.setRecipe(recipe);
        ratingEntity.setRating(rating);
        ratingRepository.save(ratingEntity);
    }

    @Override
    @Transactional
    public void updateRating(Long ratingId, int newRating) {
        RatingEntity ratingEntity = ratingRepository.findById(ratingId)
                .orElseThrow(() -> new RuntimeException("Rating not found"));
        ratingEntity.setRating(newRating);
        ratingRepository.save(ratingEntity);
    }

    @Override
    @Transactional
    public void deleteRating(Long ratingId) {
        ratingRepository.deleteById(ratingId);
    }

    @Override
    @Transactional
    public boolean isRatedByUser(Long userId, Long ratingId) {
        return ratingRepository.existsByIdAndUser_Id(ratingId, userId);
    }

    // Review methods
    @Override
    @Transactional
    public void addReview(Long userId, Long recipeId, String reviewText) {
        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        RecipeEntity recipe = recipeRepository.findById(recipeId)
                .orElseThrow(() -> new RuntimeException("Recipe not found"));

        ReviewEntity review = new ReviewEntity();
        review.setUser(user);
        review.setRecipe(recipe);
        review.setReviewText(reviewText);
        reviewRepository.save(review);
    }

    @Override
    @Transactional
    public void updateReview(Long reviewId, String newReviewText) {
        ReviewEntity review = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new RuntimeException("Review not found"));
        review.setReviewText(newReviewText);
        reviewRepository.save(review);
    }

    @Override
    @Transactional
    public void deleteReview(Long reviewId) {
        reviewRepository.deleteById(reviewId);
    }

    @Override
    @Transactional
    public boolean isReviewedByUser(Long userId, Long reviewId) {
        return reviewRepository.existsByIdAndUser_Id(reviewId, userId);
    }

}
