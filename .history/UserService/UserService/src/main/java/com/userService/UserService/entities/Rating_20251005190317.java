package com.userService.UserService.entities;

@Data
@AllArgsConstructor
@
public class Rating {
    private String ratingId;
    private String userId;
    private String hotelId;
    private int rating;
    private String feedback;
}
