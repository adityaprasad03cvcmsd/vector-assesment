package com.vector.grofers_inventory_management.service.warehouse;

import com.vector.grofers_inventory_management.entity.Warehouse;
import com.vector.grofers_inventory_management.exception.WarehouseNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WareHouseServiceImpl implements WarehouseService {

    List<Warehouse> warehouseList = new ArrayList<>();

    @Override
    public Warehouse addWarehouse(Warehouse warehouse) {
        warehouse.setId(warehouseList.size());
        warehouseList.add(warehouse);
        return warehouse;
    }

    @Override
    public Warehouse getWarehouseById(int id) {
        List<Warehouse> warehouses = warehouseList.stream().filter(e -> e.getId().equals(id)).toList();
        if (warehouses.isEmpty()) {
            throw new WarehouseNotFoundException("warehouse not found");
        }
        return warehouses.get(0);
    }

    @Override
    public List<Warehouse> getAllWarehouse() {
        return warehouseList;
    }
}
