package com.codewithdurgest.hotel_service.controllers;

import com.codewithdurgest.hotel_service.entities.Hotel;
import com.codewithdurgest.hotel_service.services.HotelService;
import com.codewithdurgest.hotel_service.services.impl.HotelServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {
    @Autowired
    private HotelService hotelService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public Hotel createHotel(@RequestBody Hotel hotel){
        return hotelService.createHotel(hotel);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{hotelId}")
    public Hotel getHotel(@PathVariable("hotelId")Long id){
        return hotelService.getHotel(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping()
    public List<Hotel> getAllHotels(){
        return hotelService.getAllHotels();
    }
}
