package com.vector.zomato_restaurant_management_system.service.orderManagement;

import com.vector.zomato_restaurant_management_system.entity.Discount;
import com.vector.zomato_restaurant_management_system.entity.Dish;
import com.vector.zomato_restaurant_management_system.entity.Order;
import com.vector.zomato_restaurant_management_system.exception.DishNotFoundException;
import com.vector.zomato_restaurant_management_system.exception.OrderNotFoundException;
import com.vector.zomato_restaurant_management_system.service.discount.DiscountService;
import com.vector.zomato_restaurant_management_system.service.dish.DishService;
import com.vector.zomato_restaurant_management_system.service.order.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderManagementService {

    @Autowired
    OrderService orderService;

    @Autowired
    DiscountService discountService;

    @Autowired
    DishService dishService;

    public Order getOrder(int orderId){
        try {
            Order order = orderService.getOrder(orderId);
            double[] totalVal = {0.0};
            order.getDishesId().forEach(e->{
                Dish dish = dishService.getDishById(e);
                totalVal[0]+= dish.getPrice();
            });

            if(order.getDiscountId()!=null){
                Discount discount = discountService.getDiscountById(order.getDiscountId());
                if(discount.getType()=="flat") {
                    totalVal[0] -= discount.getAmount();
                }else{
                    totalVal[0] = totalVal[0]*(100-discount.getAmount())/100;
                }
            }
            order.setTotal(totalVal[0]);
            return order;
        } catch (OrderNotFoundException | DishNotFoundException e){
            log.error("error at getOrder", e);
            throw e;
        }
    }
}
