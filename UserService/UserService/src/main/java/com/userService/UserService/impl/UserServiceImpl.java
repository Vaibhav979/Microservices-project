package com.userService.UserService.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.userService.UserService.entities.Hotel;
import com.userService.UserService.entities.Rating;
import com.userService.UserService.entities.User;
import com.userService.UserService.exceptions.ResourceNotFoundException;
import com.userService.UserService.repository.UserRepository;
import com.userService.UserService.services.UserService;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public User saveUser(User user) {
        String userId = UUID.randomUUID().toString();
        user.setUserId(userId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(User user, String userId) {
        User existingUser = userRepository.findById(userId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("User with given id not found on server !! " + userId));
        // Update fields as needed
        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        // Add other fields as necessary
        return userRepository.save(existingUser);
    }

    @Override
    public void deleteUser(String userId) {
        User existingUser = userRepository.findById(userId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("User with given id not found on server !! " + userId));
        userRepository.delete(existingUser);
    }

    // geting single user
    @Override
    public User getUser(String userId) {
        // get user from database with the help of userRepository
        User user = userRepository.findById(userId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("User with given id not found on server !! " + userId));
        // fetch rating of the above user from RATING SERVICE

        Rating[] ratingsOfUser = restTemplate.getForObject(
                "http://RATINGSERVICE/ratings/users/" + user.getUserId(),
                Rating[].class);
        List<Rating> ratings = Arrays.stream(ratingsOfUser).toList();
        // for each rating, we need to call hotel service and get the hotel
        List<Rating> ratingList = ratings.stream().map(rating -> {
            // api call to hotel service
            ResponseEntity<Hotel> forEntity = restTemplate
                    .getForEntity("http://HOTELSERVICE/hotels/" + rating.getHotelId(), Hotel.class);
            Hotel hotel = forEntity.getBody();
            // set the hotel to rating
            rating.setHotel(hotel);
            // return the rating
            return rating;
        }).collect(Collectors.toList());
        user.setRatings(ratingList);
        return user;
    }
}