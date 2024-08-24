package com.vector.vehichle_registration.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@SuperBuilder
public class Vehicle {

    private Integer id;

    private String vehicleNumber;

    private String type;
}
