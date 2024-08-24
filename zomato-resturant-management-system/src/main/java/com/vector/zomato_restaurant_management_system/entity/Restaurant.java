package com.vector.zomato_restaurant_management_system.entity;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class Restaurant {

    private int id;

    private String name;
}
