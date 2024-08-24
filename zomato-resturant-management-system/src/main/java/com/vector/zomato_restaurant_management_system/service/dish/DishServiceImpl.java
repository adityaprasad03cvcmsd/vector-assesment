package com.vector.zomato_restaurant_management_system.service.dish;

import com.vector.zomato_restaurant_management_system.entity.Dish;
import com.vector.zomato_restaurant_management_system.exception.DishNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DishServiceImpl implements DishService {

    List<Dish> dishList = new ArrayList<>();

    @Override
    public Dish addDish(Dish dish) {
        dish.setId(dishList.size());
        dishList.add(dish);
        return dish;
    }

    @Override
    public void removeDish(int dishId) {
        dishList.remove(dishId);
    }

    @Override
    public List<Dish> getAllDishesByRestaurantId(int restaurantId) {
        return dishList.stream().filter(e->e.getRestaurantId()==restaurantId).toList();
    }

    @Override
    public Dish getDishById(int dishId) {
        List<Dish> dishes = dishList.stream().filter(e->e.getId() == dishId).toList();
        if(dishes.isEmpty()){
            throw new DishNotFoundException("dish not found");
        }
        return dishes.get(0);
    }
}
