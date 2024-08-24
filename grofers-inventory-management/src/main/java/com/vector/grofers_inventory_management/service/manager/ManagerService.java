package com.vector.grofers_inventory_management.service.manager;

import com.vector.grofers_inventory_management.entity.Manager;

public interface ManagerService {

    Manager addManager(Manager manager);

    Manager getManagerByWarehouseId(int warehouseId);
}
