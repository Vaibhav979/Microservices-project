package com.HotelService.Hotel.repository;

import com.HotelService.Hotel.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, String> {
    
}