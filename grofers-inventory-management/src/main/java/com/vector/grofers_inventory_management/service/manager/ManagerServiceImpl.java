package com.vector.grofers_inventory_management.service.manager;

import com.vector.grofers_inventory_management.entity.Manager;
import com.vector.grofers_inventory_management.exception.ManagerNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ManagerServiceImpl implements ManagerService{

    private List<Manager> managerList = new ArrayList<>();

    @Override
    public Manager addManager(Manager manager) {
        manager.setId(managerList.size());
        managerList.add(manager);
        return manager;
    }

    @Override
    public Manager getManagerByWarehouseId(int warehouseId) {
        List<Manager> temp = managerList.stream().filter(e->e.getWarehouseId().equals(warehouseId)).collect(Collectors.toList());
        if(temp.isEmpty()){
            throw new ManagerNotFoundException("manager not found");
        }
        return temp.get(0);
    }
}
