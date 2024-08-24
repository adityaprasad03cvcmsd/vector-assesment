package com.vector.zomato_restaurant_management_system.service.order;

import com.vector.zomato_restaurant_management_system.entity.Order;

import java.util.List;

public interface OrderService {

    Order addOrder(Order order);

    void addDishesToOrder(int orderId, List<Integer> dishIdList);

    void addDiscountToOrder(int orderId, int discount);

    List<Order> getAllOrdersBYRestaurantId(int restaurantId);

    Order getOrder(int orderId);
}
