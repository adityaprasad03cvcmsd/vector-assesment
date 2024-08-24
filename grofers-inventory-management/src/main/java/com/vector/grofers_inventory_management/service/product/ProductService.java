package com.vector.grofers_inventory_management.service.product;

import com.vector.grofers_inventory_management.entity.Product;

import java.util.List;

public interface ProductService {

    Product addProduct(Product product);

    Product getProductById(int id);

    Product decreaseQuantityFromProductById(int id, int amount);

    List<Product> getAllProductByWarehouseId(int warehouseId);
}
