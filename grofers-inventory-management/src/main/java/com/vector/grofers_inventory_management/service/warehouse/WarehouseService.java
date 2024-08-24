package com.vector.grofers_inventory_management.service.warehouse;

import com.vector.grofers_inventory_management.entity.Warehouse;

import java.util.List;

public interface WarehouseService {

    Warehouse addWarehouse(Warehouse warehouse);

    Warehouse getWarehouseById(int id);

    List<Warehouse>getAllWarehouse();
}
