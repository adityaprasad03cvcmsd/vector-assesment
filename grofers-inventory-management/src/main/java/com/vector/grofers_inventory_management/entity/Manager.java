package com.vector.grofers_inventory_management.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Manager {

    private Integer id;

    private String name;

    private String location;

    private Integer warehouseId;
}
