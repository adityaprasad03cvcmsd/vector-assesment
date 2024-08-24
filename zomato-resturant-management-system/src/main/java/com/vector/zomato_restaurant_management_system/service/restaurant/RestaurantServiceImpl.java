package com.vector.zomato_restaurant_management_system.service.restaurant;

import com.vector.zomato_restaurant_management_system.entity.Restaurant;
import com.vector.zomato_restaurant_management_system.exception.RestaurantNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService{

    private List<Restaurant> restaurantList = new ArrayList<>();

    @Override
    public Restaurant addRestaurant(Restaurant restaurant) {
        restaurant.setId(restaurantList.size());
        restaurantList.add(restaurant);
        return restaurant;
    }

    @Override
    public Restaurant getRestaurantById(int id) {
        List<Restaurant> restaurants = restaurantList.stream().filter(e->e.getId()==id).toList();
        if(restaurants.isEmpty()){
            throw new RestaurantNotFoundException("restaurant not found");
        }
        return restaurants.get(0);
    }
}
