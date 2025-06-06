package com.example.restaurantlisting.mapper;


import com.example.restaurantlisting.dto.RestaurantDTO;
import com.example.restaurantlisting.entity.RestaurantEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RestaurantMapper {
    RestaurantMapper INSTANCE = Mappers.getMapper(RestaurantMapper.class);

    /* These are the abstract method  */
    // Return Restaurant Entity when you have RestaurantDTO
    RestaurantEntity mapRestaurantDtoToRestaurantEntity(RestaurantDTO restaurantDto);

    // Return RestaurantDto Entity when you have RestaurantEntity
    RestaurantDTO mapRestaurantEntityToRestaurantDto(RestaurantEntity restaurantEntity);
}
