package com.lcwd.user.service.external.services;

import com.lcwd.user.service.entities.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "HOTEL-SERVICE")
public interface HotelService {

    //this method will give its implementation automatically at runtime(because it is an interface) with the help of @FeignClient annotation.
    //This is called declarative approach
    @GetMapping("/hotels/{hotelId}")
    Hotel getHotel(@PathVariable String hotelId);

}
