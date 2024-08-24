package com.vector.zomato_restaurant_management_system.service.order;

import com.vector.zomato_restaurant_management_system.entity.Order;
import com.vector.zomato_restaurant_management_system.exception.OrderNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{

    List<Order> orderList = new ArrayList<>();

    @Override
    public Order addOrder(Order order) {
        order.setId(orderList.size());
        orderList.add(order);
        return order;
    }

    @Override
    public void addDishesToOrder(int orderId, List<Integer> dishIdList) {
        List<Order> orders = orderList.stream().filter(e->e.getId()==orderId).toList();
        if(orders.isEmpty()){
            throw new OrderNotFoundException("order not found");
        }
        List<Integer> tempIds = orders.get(0).getDishesId();
        tempIds.addAll(dishIdList);
        orders.get(0).setDishesId(tempIds);
    }

    @Override
    public void addDiscountToOrder(int orderId, int discountId) {
        List<Order> orders = orderList.stream().filter(e->e.getId()==orderId).toList();
        if(orders.isEmpty()){
            throw new OrderNotFoundException("order not found");
        }
        orders.get(0).setDiscountId(discountId);
    }

    @Override
    public List<Order> getAllOrdersBYRestaurantId(int restaurantId) {
        return orderList.stream().filter(e->e.getRestaurantId()==restaurantId).toList();
    }

    @Override
    public Order getOrder(int orderId) {
        List<Order> orders = orderList.stream().filter(e->e.getId()==orderId).toList();
        if(orders.isEmpty()){
            throw new OrderNotFoundException("order not found");
        }
        return orders.get(0);
    }

}
