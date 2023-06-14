package com.codewithdurgest.hotel_service.services.impl;

import com.codewithdurgest.hotel_service.entities.Hotel;
import com.codewithdurgest.hotel_service.exceptions.ResourceNotFoundException;
import com.codewithdurgest.hotel_service.repositories.HotelRepository;
import com.codewithdurgest.hotel_service.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {
    @Autowired
    HotelRepository hotelRepository;
    @Override
    public Hotel createHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel getHotel(Long id) {
        return hotelRepository.findById(id)
                .orElseThrow(
                        ()-> new ResourceNotFoundException("Hotel with id:" + id + " not found")
                );
    }
}
