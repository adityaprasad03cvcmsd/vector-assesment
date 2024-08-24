package com.vector.zomato_restaurant_management_system.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class DishNotFoundException extends RuntimeException{

    private String message;
}
