package com.lcwd.hotel.services.impl;

import com.lcwd.hotel.dto.HotelName;
import com.lcwd.hotel.entities.Hotel;
import com.lcwd.hotel.exceptions.ResourceNotFoundException;
import com.lcwd.hotel.repositories.HotelRepo;
import com.lcwd.hotel.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepo hotelRepo;
    @Override
    public Hotel create(Hotel hotel) {
        System.out.println("inside service");
        String random = UUID.randomUUID().toString();
        System.out.println("inside service1");
        hotel.setHotelId(random);
        System.out.println("inside service1");
        return hotelRepo.save(hotel);
    }

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepo.findAll();
    }

    @Override
    public Hotel getHotel(String hotelId) {
        return hotelRepo.findById(hotelId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + hotelId));
    }

    @Override
    public Optional<HotelName> getHotelDetailsByName(String name) {
        Optional<Hotel> hotel = hotelRepo.findByName(name);
        return hotel.map(h -> new HotelName(h.getHotelId(), h.getLocation(),h.getAbout()));
    }
}
