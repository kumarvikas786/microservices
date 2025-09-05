package com.lcwd.hotel.repositories;

import com.lcwd.hotel.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HotelRepo extends JpaRepository<Hotel,String> {

    // if you want to create any custom method or query
    // you can write

    Optional<Hotel> findByName(String name);

}
