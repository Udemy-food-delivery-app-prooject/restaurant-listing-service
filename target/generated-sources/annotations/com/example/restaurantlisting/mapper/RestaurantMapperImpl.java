package com.example.restaurantlisting.mapper;

import com.example.restaurantlisting.dto.RestaurantDTO;
import com.example.restaurantlisting.entity.RestaurantEntity;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-06-04T23:12:58-0400",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 18.0.2.1 (Oracle Corporation)"
)
public class RestaurantMapperImpl implements RestaurantMapper {

    @Override
    public RestaurantEntity mapRestaurantDtoToRestaurantEntity(RestaurantDTO restaurantDto) {
        if ( restaurantDto == null ) {
            return null;
        }

        RestaurantEntity.RestaurantEntityBuilder restaurantEntity = RestaurantEntity.builder();

        if ( restaurantDto.getId() != null ) {
            restaurantEntity.id( Integer.parseInt( restaurantDto.getId() ) );
        }
        restaurantEntity.name( restaurantDto.getName() );
        restaurantEntity.address( restaurantDto.getAddress() );
        restaurantEntity.city( restaurantDto.getCity() );
        restaurantEntity.restaurantDescription( restaurantDto.getRestaurantDescription() );

        return restaurantEntity.build();
    }

    @Override
    public RestaurantDTO mapRestaurantEntityToRestaurantDto(RestaurantEntity restaurantEntity) {
        if ( restaurantEntity == null ) {
            return null;
        }

        RestaurantDTO.RestaurantDTOBuilder restaurantDTO = RestaurantDTO.builder();

        if ( restaurantEntity.getId() != null ) {
            restaurantDTO.id( String.valueOf( restaurantEntity.getId() ) );
        }
        restaurantDTO.name( restaurantEntity.getName() );
        restaurantDTO.address( restaurantEntity.getAddress() );
        restaurantDTO.city( restaurantEntity.getCity() );
        restaurantDTO.restaurantDescription( restaurantEntity.getRestaurantDescription() );

        return restaurantDTO.build();
    }
}
