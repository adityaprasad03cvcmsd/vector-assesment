package com.vector.grofers_inventory_management.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductNotFoundException extends RuntimeException{

    private String message;
}
