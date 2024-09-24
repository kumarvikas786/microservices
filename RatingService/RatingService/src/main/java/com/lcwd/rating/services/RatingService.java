package com.lcwd.rating.services;

import com.lcwd.rating.dto.UserHotelRatingDTO;
import com.lcwd.rating.entities.Rating;

import java.util.List;

public interface RatingService {



    //create

    Rating create(Rating rating);

    //get All Ratings

    List<Rating> getAll();

    //get all by user Id

    List<Rating> getRatingByUserId(String userId);

    //get All by Hotel

    List<Rating> getRatingByHotelId(String hotelId);

    List<UserHotelRatingDTO> getUserIdAndHotelIdByRating(int rating);

}
