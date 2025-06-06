package com.example.restaurantlisting.controller;

import com.example.restaurantlisting.dto.RestaurantDTO;
import com.example.restaurantlisting.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurant")
@CrossOrigin
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping
    public ResponseEntity<List<RestaurantDTO>> getAllRestaurants() {
        List<RestaurantDTO> allRestaurants = restaurantService.findAllRestaurant();
        return new ResponseEntity<>(allRestaurants,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestaurantDTO> getRestaurantById(@PathVariable Integer id) {
        return restaurantService.getRestaurantById(id);
    }

    @PostMapping
    public ResponseEntity<RestaurantDTO> addRestaurant(@RequestBody RestaurantDTO restaurantDTO) {
        return new ResponseEntity<>(restaurantService.addRestaurant(restaurantDTO), HttpStatus.OK);
    }
}
