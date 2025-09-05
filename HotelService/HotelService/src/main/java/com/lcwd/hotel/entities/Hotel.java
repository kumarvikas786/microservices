package com.lcwd.hotel.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "hotels")
@Data
public class Hotel {

    @Id
    @Column(name = "ID")
    private String hotelId;
    private String name;
    private String location;
    private String about;


}
