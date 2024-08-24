package com.vector.zomato_restaurant_management_system;

import com.vector.zomato_restaurant_management_system.entity.Discount;
import com.vector.zomato_restaurant_management_system.entity.Dish;
import com.vector.zomato_restaurant_management_system.entity.Order;
import com.vector.zomato_restaurant_management_system.entity.Restaurant;
import com.vector.zomato_restaurant_management_system.service.discount.DiscountService;
import com.vector.zomato_restaurant_management_system.service.dish.DishService;
import com.vector.zomato_restaurant_management_system.service.order.OrderService;
import com.vector.zomato_restaurant_management_system.service.orderManagement.OrderManagementService;
import com.vector.zomato_restaurant_management_system.service.restaurant.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Test {

    @Autowired
    OrderManagementService orderManagementService;

    @Autowired
    OrderService orderService;

    @Autowired
    RestaurantService restaurantService;

    @Autowired
    DishService dishService;

    @Autowired
    DiscountService discountService;

    @GetMapping("/test")
    public void test(){
        Restaurant restaurant = restaurantService.addRestaurant(Restaurant.builder().name("dum biryani").build());
        Dish dish = dishService.addDish(Dish.builder().price(200.00).name("biryani regular").restaurantId(restaurant.getId()).isDeleted(false).build());
        Dish dish2 = dishService.addDish(Dish.builder().price(180.00).name("biryani small").restaurantId(restaurant.getId()).isDeleted(false).build());

        Discount discount = discountService.addDiscount(Discount.builder().type("flat").amount(50.00).isActive(true).restaurantId(restaurant.getId()).build());
        List<Integer> orderedDishes = new ArrayList<>();
        orderedDishes.add(dish2.getId());
        Order order = orderService.addOrder(Order.builder().type("dilevery").restaurantId(restaurant.getId()).dishesId(orderedDishes).build());

        System.out.println(orderManagementService.getOrder(order.getId()));

        orderService.addDishesToOrder(order.getId(), orderedDishes);
        System.out.println(orderManagementService.getOrder(order.getId()));

        orderService.addDiscountToOrder(order.getId(), discount.getId());
        System.out.println(orderManagementService.getOrder(order.getId()));
    }
}
