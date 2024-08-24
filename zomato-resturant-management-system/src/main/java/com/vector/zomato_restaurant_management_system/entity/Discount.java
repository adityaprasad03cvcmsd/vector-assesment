package com.vector.zomato_restaurant_management_system.entity;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class Discount {

    private int id;

    private int restaurantId;

    private String type;

    private double amount;

    private boolean isActive;
}
