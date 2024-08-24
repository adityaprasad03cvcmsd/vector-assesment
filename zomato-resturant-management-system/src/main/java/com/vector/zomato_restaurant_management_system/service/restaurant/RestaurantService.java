package com.vector.zomato_restaurant_management_system.service.restaurant;

import com.vector.zomato_restaurant_management_system.entity.Restaurant;

public interface RestaurantService {

    Restaurant addRestaurant(Restaurant restaurant);

    Restaurant getRestaurantById(int id);
}
