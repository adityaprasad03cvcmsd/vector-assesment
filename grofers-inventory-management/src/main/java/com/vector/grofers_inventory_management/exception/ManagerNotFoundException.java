package com.vector.grofers_inventory_management.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ManagerNotFoundException extends RuntimeException{

    private String message;
}
