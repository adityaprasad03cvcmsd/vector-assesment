package com.vector.zomato_restaurant_management_system.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderNotFoundException extends RuntimeException{

    private String message;
}
