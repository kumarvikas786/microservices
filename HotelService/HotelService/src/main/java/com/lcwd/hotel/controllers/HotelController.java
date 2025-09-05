package com.lcwd.hotel.controllers;

import com.lcwd.hotel.dto.HotelName;
import com.lcwd.hotel.entities.Hotel;
import com.lcwd.hotel.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;


    @PostMapping("/createhotel")
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
    System.out.println("inside controller");
        Hotel saveHotel = hotelService.create(hotel);
        System.out.println("inside controller1");
        return new ResponseEntity<>(saveHotel, HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Hotel>> getAll(){
        List<Hotel> hotelList = hotelService.getAllHotels();
        return new ResponseEntity<>(hotelList,HttpStatus.OK);
    }


    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> getHotel(@PathVariable  String hotelId){
        Hotel hotel = hotelService.getHotel(hotelId);
        return new ResponseEntity<>(hotel,HttpStatus.OK);
    }

    @GetMapping("/by-name/{name}")
    public ResponseEntity<HotelName> getByName(@PathVariable String name){
        Optional<HotelName> hotelName = hotelService.getHotelDetailsByName(name);
//        return new ResponseEntity<>(hotelName,HttpStatus.OK);
        return hotelName.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
