package com.vector.grofers_inventory_management;

import com.vector.grofers_inventory_management.entity.Manager;
import com.vector.grofers_inventory_management.entity.Product;
import com.vector.grofers_inventory_management.entity.Warehouse;
import com.vector.grofers_inventory_management.service.manager.ManagerService;
import com.vector.grofers_inventory_management.service.productManagagement.ProductManagementService;
import com.vector.grofers_inventory_management.service.warehouse.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {

    @Autowired
    WarehouseService warehouseService;

    @Autowired
    ProductManagementService productManagementService;

    @Autowired
    ManagerService managerService;

    @GetMapping("/test")
    public void testing (){
        Warehouse warehouse = warehouseService.addWarehouse(new Warehouse(0, "bangalore"));
        Manager manager = managerService.addManager(new Manager(0, "ashok", "bangalore", warehouse.getId()));
        Product product = productManagementService.addProduct(Product.builder().name("parle-g").alertQuantity(30).warehouseId(warehouse.getId()).quantity(50).build());


        Warehouse warehouse2 = warehouseService.addWarehouse(new Warehouse(0, "bangalore"));
        Manager manager2 = managerService.addManager(new Manager(0, "ashok", "bangalore", warehouse2.getId()));
        Product product2 = productManagementService.addProduct(Product.builder().name("coconut oil").alertQuantity(30).warehouseId(warehouse2.getId()).quantity(31).build());

        productManagementService.decreaseQuantityFromProductById(product2.getId(), 3);
    }
}
