package com.userService.UserService.entities;

@Data

public class Rating {
    private String ratingId;
    private String userId;
    private String hotelId;
    private int rating;
    private String feedback;
}
