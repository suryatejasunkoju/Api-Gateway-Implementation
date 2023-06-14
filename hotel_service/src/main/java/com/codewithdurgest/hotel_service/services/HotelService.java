package com.codewithdurgest.hotel_service.services;

import com.codewithdurgest.hotel_service.entities.Hotel;

import java.util.List;

public interface HotelService {
    Hotel createHotel(Hotel hotel);
    List<Hotel> getAllHotels();
    Hotel getHotel(Long id);
}
