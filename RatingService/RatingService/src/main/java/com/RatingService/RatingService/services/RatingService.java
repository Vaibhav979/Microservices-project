package com.RatingService.RatingService.services;

import com.RatingService.RatingService.entities.Rating;
import java.util.List;

public interface RatingService {
    
    // create
    Rating create(Rating rating);

    // get all ratings
    List<Rating> getRatings();

    // get all ratings by userId
    List<Rating> getRatingByUserId(String userId);

    // get all ratings by hotelId
    List<Rating> getRatingByHotelId(String hotelId);
}
