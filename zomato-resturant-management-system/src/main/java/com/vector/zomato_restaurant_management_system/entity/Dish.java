package com.vector.zomato_restaurant_management_system.entity;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class Dish {

    private int id;

    private String name;

    private Double price;

    private boolean isDeleted;

    private int restaurantId;
}
