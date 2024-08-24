package com.vector.zomato_restaurant_management_system.service.discount;

import com.vector.zomato_restaurant_management_system.entity.Discount;

import java.util.List;

public interface DiscountService {

    Discount addDiscount(Discount discount);

    void removeDiscount(int discountId);

    List<Discount> allDiscountsByRestaurantId(int restaurantId);

    Discount getDiscountById(int id);
}
