package com.example.restaurantlisting.service;

import com.example.restaurantlisting.dto.RestaurantDTO;
import com.example.restaurantlisting.entity.RestaurantEntity;
import com.example.restaurantlisting.mapper.RestaurantMapper;
import com.example.restaurantlisting.repository.RestaurantRepository;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RestaurantService {
    @Autowired
    private RestaurantRepository restaurantRepository;

    public List<RestaurantDTO> findAllRestaurant() {
        List<RestaurantEntity> allRestaurants = restaurantRepository.findAll();

        // Map Entity to DTO else it will throw an exception.
        List<RestaurantDTO> restaurants = allRestaurants.stream()
                .map(restaurant -> RestaurantMapper.INSTANCE.mapRestaurantEntityToRestaurantDto(restaurant))
                .collect(Collectors.toList());
        return restaurants;
    }

    public ResponseEntity<RestaurantDTO> getRestaurantById(int restaurantId) {
        Optional<RestaurantEntity> restaurantDetail = restaurantRepository.findById(restaurantId);
        return restaurantDetail
                .map(restaurantEntity -> new ResponseEntity<>(RestaurantMapper.INSTANCE.mapRestaurantEntityToRestaurantDto(restaurantEntity), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));

    }

    public RestaurantDTO addRestaurant(RestaurantDTO restaurantDTO) {
        RestaurantEntity saveRestaurant = restaurantRepository.save(RestaurantMapper.INSTANCE.mapRestaurantDtoToRestaurantEntity(restaurantDTO));
        return RestaurantMapper.INSTANCE.mapRestaurantEntityToRestaurantDto(saveRestaurant);
    }
}
