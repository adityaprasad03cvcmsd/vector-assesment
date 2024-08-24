package com.vector.grofers_inventory_management.service.product;

import com.vector.grofers_inventory_management.entity.Product;
import com.vector.grofers_inventory_management.exception.ProductNotFoundException;
import com.vector.grofers_inventory_management.exception.ProductQuantityNotAvailableException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private List<Product> productList = new ArrayList<>();

    @Override
    public Product addProduct(Product product) {
        product.setId(productList.size());
        productList.add(product);
        return product;
    }

    @Override
    public Product getProductById(int id) {
        List<Product> products = productList.stream().filter(e->e.getId()==(id)).toList();
        if(products.isEmpty()){
            throw new ProductNotFoundException("product not found");
        }
        return products.get(0);
    }

    @Override
    public Product decreaseQuantityFromProductById(int id, int amount) {
        Product product = getProductById(id);
        if(product.getQuantity()<amount){
            throw new ProductQuantityNotAvailableException("amount of product requested is not available");
        }
        product.setQuantity(product.getQuantity()-amount);
        return product;
    }

    @Override
    public List<Product> getAllProductByWarehouseId(int warehouseId) {
        return productList.stream().filter(e->e.getWarehouseId().equals(warehouseId)).toList();
    }
}
