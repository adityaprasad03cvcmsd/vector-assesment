package com.vector.grofers_inventory_management.service.productManagagement;

import com.vector.grofers_inventory_management.entity.Manager;
import com.vector.grofers_inventory_management.entity.Product;
import com.vector.grofers_inventory_management.exception.ManagerNotFoundException;
import com.vector.grofers_inventory_management.exception.ProductNotFoundException;
import com.vector.grofers_inventory_management.exception.ProductOrderFailedException;
import com.vector.grofers_inventory_management.exception.ProductQuantityNotAvailableException;
import com.vector.grofers_inventory_management.service.manager.ManagerService;
import com.vector.grofers_inventory_management.service.notification.NotificationService;
import com.vector.grofers_inventory_management.service.product.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProductManagementService {

    @Autowired
    ProductService productService;

    @Autowired
    NotificationService notificationService;

    @Autowired
    ManagerService managerService;

    public Product addProduct(Product product) {
        return productService.addProduct(product);
    }

    public Product decreaseQuantityFromProductById(int id, int amount) {
        try {
            Product product = productService.decreaseQuantityFromProductById(id, amount);
            if (product.getQuantity() <= product.getAlertQuantity()) {
                processAlert(product);
            }
            return product;
        } catch (ProductQuantityNotAvailableException e) {
            log.info("error at decreaseQuantityFromProductById", e);
            processAlert(productService.getProductById(id));
            throw new ProductOrderFailedException("product order failed");
        } catch (ProductNotFoundException e) {
            log.info("error at decreaseQuantityFromProductById", e);
            throw new ProductOrderFailedException("product order failed");
        } catch (Exception e) {
            log.info("error at decreaseQuantityFromProductById -{}", e.getMessage(), e);
            throw new ProductOrderFailedException("product order failed");
        }
    }

    public List<Product> getAllProductByWarehouseId(int warehouseId) {
        return productService.getAllProductByWarehouseId(warehouseId);
    }

    private void processAlert(Product product) {
        try {
            Manager manager = managerService.getManagerByWarehouseId(product.getWarehouseId());
            notificationService.sendAlertToManagerForProduct(manager, product);
        } catch (ManagerNotFoundException e) {
            log.error("error at processAlert");
        }

    }

}
