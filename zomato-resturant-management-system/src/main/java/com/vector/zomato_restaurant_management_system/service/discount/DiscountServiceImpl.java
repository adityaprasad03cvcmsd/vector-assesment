package com.vector.zomato_restaurant_management_system.service.discount;

import com.vector.zomato_restaurant_management_system.entity.Discount;
import com.vector.zomato_restaurant_management_system.exception.DiscountNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DiscountServiceImpl implements DiscountService{

    private List<Discount> discountList = new ArrayList<>();

    @Override
    public Discount addDiscount(Discount discount) {
        discount.setId(discountList.size());
        discountList.add(discount);
        return discount;
    }

    @Override
    public void removeDiscount(int discountId) {
        List<Discount> discounts = discountList.stream().filter(e->e.getId()==discountId).toList();
        if(discounts.isEmpty()){
            throw new DiscountNotFoundException("discount not found");
        }
        discounts.get(0).setActive(false);
    }

    @Override
    public List<Discount> allDiscountsByRestaurantId(int restaurantId) {
        return discountList.stream().filter(e->e.getRestaurantId() == restaurantId).toList();
    }

    @Override
    public Discount getDiscountById(int id) {
        List<Discount> discounts = discountList.stream().filter(e->e.getId()==id).toList();
        if(discounts.isEmpty()){
            throw new DiscountNotFoundException("discount not found");
        }
        return discounts.get(0);
    }
}
