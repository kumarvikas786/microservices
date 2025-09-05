package com.lcwd.hotel.services;

import com.lcwd.hotel.dto.HotelName;
import com.lcwd.hotel.entities.Hotel;

import java.util.List;
import java.util.Optional;

public interface HotelService {

    //create hotel
    Hotel create(Hotel hotel);

    //get All hotels

    List<Hotel> getAllHotels();

    //get hotel by Id

    Hotel getHotel(String hotelId);

    Optional<HotelName> getHotelDetailsByName(String name);
}
