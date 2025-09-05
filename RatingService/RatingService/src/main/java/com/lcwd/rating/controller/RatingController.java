package com.lcwd.rating.controller;

import com.lcwd.rating.dto.UserHotelRatingDTO;
import com.lcwd.rating.entities.Rating;
import com.lcwd.rating.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rating")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping("/create")
    public ResponseEntity<Rating> create(@RequestBody Rating rating){
        System.out.println(rating.getHotelId());
        Rating createRating = ratingService.create(rating);
        return  new ResponseEntity<>(createRating, HttpStatus.CREATED);
    }

    @GetMapping("/getall")
    public ResponseEntity<List<Rating>> getAll(){
        List<Rating> allRating = ratingService.getAll();
        return new ResponseEntity<>(allRating,HttpStatus.OK);
    }

    @GetMapping("getratingbyuserid/{userId}")
    public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable String userId){
        List<Rating> getRating = ratingService.getRatingByUserId(userId);
        return new ResponseEntity<>(getRating,HttpStatus.OK);
    }


    @GetMapping("getratingbyhotelid/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable String hotelId){
        List<Rating> getRating = ratingService.getRatingByHotelId(hotelId);
        return new ResponseEntity<>(getRating,HttpStatus.OK);
    }

    @GetMapping("/by-rating/{rating}")
    public ResponseEntity<List<UserHotelRatingDTO>> getByRating(@PathVariable int rating){
        List<UserHotelRatingDTO> byRating = ratingService.getUserIdAndHotelIdByRating(rating);
        return new ResponseEntity<>(byRating, HttpStatus.OK);
    }

}
