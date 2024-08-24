package com.vector.zomato_restaurant_management_system.service.dish;

import com.vector.zomato_restaurant_management_system.entity.Dish;

import java.util.List;

public interface DishService {

    Dish addDish(Dish dish);

    void removeDish(int dishId);

    List<Dish> getAllDishesByRestaurantId(int restaurantId);

    Dish getDishById(int dishId);
}
