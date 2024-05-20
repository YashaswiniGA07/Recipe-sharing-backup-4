package com.recipesharing.app.serviceimpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recipesharing.app.dto.CommentDTO;
import com.recipesharing.app.dto.RatingDTO;
import com.recipesharing.app.dto.RecipeDTO;
import com.recipesharing.app.dto.RecipeResponseDTO;
import com.recipesharing.app.dto.ReviewDTO;
import com.recipesharing.app.entity.CommentEntity;
import com.recipesharing.app.entity.RatingEntity;
import com.recipesharing.app.entity.RecipeEntity;
import com.recipesharing.app.entity.ReviewEntity;
import com.recipesharing.app.repository.CommentRepository;
import com.recipesharing.app.repository.LikeRepository;
import com.recipesharing.app.repository.RatingRepository;
import com.recipesharing.app.repository.RecipeRepository;
import com.recipesharing.app.repository.ReviewRepository;
import com.recipesharing.app.service.RecipeService;


@Service
public class RecipeServiceImpl implements RecipeService {
	private final RecipeRepository reciperepo;
    private final LikeRepository likeRepository;
    private final CommentRepository commentRepository;
    private final RatingRepository ratingRepository;
    private final ReviewRepository reviewRepository;


//	@Autowired
//	public RecipeServiceImpl(RecipeRepository reciperepo)
//	{
//		this.reciperepo=reciperepo;
//	}
	
	@Autowired
    public RecipeServiceImpl(RecipeRepository reciperepo, LikeRepository likeRepository,
                             CommentRepository commentRepository, RatingRepository ratingRepository,
                             ReviewRepository reviewRepository) {
        this.reciperepo = reciperepo;
        this.likeRepository = likeRepository;
        this.commentRepository = commentRepository;
        this.ratingRepository = ratingRepository;
        this.reviewRepository = reviewRepository;
    }



	@Override
	public List<RecipeEntity> getAllRecipes() {
		// TODO Auto-generated method stub
		return reciperepo.findAll();
	}

	@Override
	public Optional<RecipeEntity> getRecipeById(Long id) {
		// TODO Auto-generated method stub
		return reciperepo.findById(id);
	}

	@Override
	public RecipeEntity createRecipe(RecipeEntity recipe) {
		// TODO Auto-generated method stub
		return reciperepo.save(recipe);
	}

	@Override
	public RecipeEntity updateRecipe(RecipeEntity recipe) {
		// TODO Auto-generated method stub
		Long id = recipe.getRecipeId(); 
	    Optional<RecipeEntity> existingRecipeOptional = reciperepo.findById(id);
	    
	    if (existingRecipeOptional.isPresent()) {
	        RecipeEntity existingRecipe = existingRecipeOptional.get();
	        existingRecipe.setTitle(recipe.getTitle());
	        existingRecipe.setDescription(recipe.getDescription());
	        existingRecipe.setIngredients(recipe.getIngredients());
	        existingRecipe.setPreperationSteps(recipe.getPreperationSteps());
	        existingRecipe.setCategory(recipe.getCategory());
	        existingRecipe.setCuisine(recipe.getCuisine());
	        existingRecipe.setDifficulty(recipe.getDifficulty());
	        
	        
	        return reciperepo.save(existingRecipe);
	    } else {
	        // Recipe with the given ID not found
	        throw new RuntimeException("Recipe not found with ID: " + id);
	    }
	}

	@Override
	public String deleteRecipe(Long id) {
		// TODO Auto-generated method stub
		reciperepo.deleteById(id);
		return "Recipe Deleted Succesfully";
		
	}
	
	@Override
    public RecipeResponseDTO getDetailedRecipeById(Long id) {
        RecipeEntity recipe = reciperepo.findById(id).orElseThrow(() -> new RuntimeException("Recipe not found with ID: " + id));

        RecipeDTO recipeDTO = new RecipeDTO();
        recipeDTO.setRecipeId(recipe.getRecipeId());
        recipeDTO.setTitle(recipe.getTitle());
        recipeDTO.setDescription(recipe.getDescription());
        recipeDTO.setIngredients(recipe.getIngredients());
        recipeDTO.setPreperationSteps(recipe.getPreperationSteps());
        recipeDTO.setCategory(recipe.getCategory());
        recipeDTO.setCuisine(recipe.getCuisine());
        recipeDTO.setDifficulty(recipe.getDifficulty());

        int likeCount = likeRepository.countByRecipeId(id);

        List<CommentDTO> comments = commentRepository.findByRecipeId(id).stream().map(comment -> {
            CommentDTO dto = new CommentDTO();
            dto.setId(comment.getId());
            dto.setCommentText(comment.getCommentText());
            dto.setCreatedAt(comment.getCreatedAt());
            dto.setUpdatedAt(comment.getUpdatedAt());
            return dto;
        }).collect(Collectors.toList());

        List<ReviewDTO> reviews = reviewRepository.findByRecipeId(id).stream().map(review -> {
            ReviewDTO dto = new ReviewDTO();
            dto.setId(review.getId());
            dto.setReviewText(review.getReviewText());
            dto.setCreatedAt(review.getCreatedAt());
            dto.setUpdatedAt(review.getUpdatedAt());
            return dto;
        }).collect(Collectors.toList());

        List<RatingDTO> ratings = ratingRepository.findByRecipeId(id).stream().map(rating -> {
            RatingDTO dto = new RatingDTO();
            dto.setId(rating.getId());
            dto.setRating(rating.getRating());
            dto.setCreatedAt(rating.getCreatedAt());
            dto.setUpdatedAt(rating.getUpdatedAt());
            return dto;
        }).collect(Collectors.toList());

        RecipeResponseDTO response = new RecipeResponseDTO();
        response.setRecipe(recipeDTO);
        response.setLikeCount(likeCount);
        response.setComments(comments);
        response.setReviews(reviews);
        response.setRatings(ratings);

        return response;
    }

	
	
	
}
