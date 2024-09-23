package com.lcwd.rating.services.impl;

import com.lcwd.rating.dto.UserHotelRatingDTO;
import com.lcwd.rating.entities.Rating;
import com.lcwd.rating.repositories.RatingRepo;
import com.lcwd.rating.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepo ratingRepo;

    @Override
    public Rating create(Rating rating) {
        return ratingRepo.save(rating);
    }

    @Override
    public List<Rating> getAll() {
        return ratingRepo.findAll();
    }

    @Override
    public List<Rating> getRatingByUserId(String userId) {
        return ratingRepo.findByUserId(userId);
    }

    @Override
    public List<Rating> getRatingByHotelId(String hotelId) {
        return ratingRepo.findByHotelId(hotelId);
    }

    @Override
    public List<UserHotelRatingDTO> getUserIdAndHotelIdByRating(int rating) {
        List<Rating> ratings = ratingRepo.findByRating(rating);
        return ratings.stream()
                .map(r -> new UserHotelRatingDTO(r.getUserId(), r.getHotelId()))
                .collect(Collectors.toList());
    }
}
