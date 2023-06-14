package com.codewithdurgest.hotel_service.repositories;

import com.codewithdurgest.hotel_service.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {
}
