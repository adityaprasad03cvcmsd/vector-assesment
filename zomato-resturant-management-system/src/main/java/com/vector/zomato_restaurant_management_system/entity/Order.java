package com.vector.zomato_restaurant_management_system.entity;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
public class Order {

    private int id;

    private String type;

    private List<Integer> dishesId;

    private Double total;

    private Integer discountId;

    private Integer restaurantId;

}
