package com.example.restaurantlisting.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RestaurantDTO {

    private String id;
    private String name;
    private String address;
    private String city;
    private String restaurantDescription;
}
