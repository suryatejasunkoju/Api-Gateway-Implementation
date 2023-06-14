package com.codewithdurgesh.user_service.service.impl;

import com.codewithdurgesh.user_service.entities.Hotel;
import com.codewithdurgesh.user_service.entities.Rating;
import com.codewithdurgesh.user_service.entities.User;
import com.codewithdurgesh.user_service.repository.UserRepository;
import com.codewithdurgesh.user_service.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.lang.module.ResolutionException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RestTemplate restTemplate;

//    @Autowired
//    Logger logger= LoggerFactory.getLogger(UserServiceImpl.class);
    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(Long id) {
        //getting user from DB
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResolutionException("User with id:" + id + " is not found"));
        //getting rating from rating_service
        String url ="http://localhost:8083/ratings/users/";
        Rating[] userRatings = restTemplate.getForObject(url+user.getId(), Rating[].class);
        //System.out.println("---------------------"+userRatings);
        List<Rating> ratings = Arrays.stream(userRatings).toList();
        List<Rating> ratingList = ratings.stream().map(rating -> {
            ResponseEntity<Hotel> hotelEntity = restTemplate.getForEntity("localhost:8082/hotels/2" + rating.getHotelId(), Hotel.class);
            Hotel hotel = hotelEntity.getBody();
            System.out.println("-------------hotel=" + hotel);
            rating.setHotel(hotel);
            return rating;
        }).toList();

        user.setRatings(ratingList);
        return user;
    }
}
