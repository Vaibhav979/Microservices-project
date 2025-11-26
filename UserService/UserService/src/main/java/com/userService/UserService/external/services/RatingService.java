package com.userService.UserService.external.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import com.userService.UserService.entities.Rating;

@FeignClient(name = "RATINGSERVICE")
public interface RatingService {
    @PostMapping("/ratings/{ratingId}")
    Rating createRating(@PathVariable String ratingId, Rating rating);

    @PutMapping("/ratings/{ratingId}")
    Rating updateRating(@PathVariable String ratingId, Rating rating);

    @DeleteMapping("/ratings/{ratingId}")
    void deleteRating(@PathVariable String ratingId);

    @PostMapping("/ratings")
    Rating createRating(Rating rating);

    @GetMapping("/ratings/users/{userId}")
    Rating[] getRatingsByUserId(@PathVariable String userId);
}
