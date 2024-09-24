package com.lcwd.rating.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserHotelRatingDTO {
    private String userId;
    private String hotelId;

}
