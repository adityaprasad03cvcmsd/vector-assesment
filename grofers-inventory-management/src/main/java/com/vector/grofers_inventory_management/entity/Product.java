package com.vector.grofers_inventory_management.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@SuperBuilder
public class Product {

    private int id;

    private String name;

    private Integer quantity;

    private Integer alertQuantity;

    private Integer warehouseId;
}
