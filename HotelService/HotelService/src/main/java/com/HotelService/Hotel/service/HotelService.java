package com.HotelService.Hotel.service;

import com.HotelService.Hotel.entities.Hotel;
import java.util.List;

public interface HotelService {
    Hotel create(Hotel hotel);

    List<Hotel> getAll();

    Hotel getHotel(String id);
}