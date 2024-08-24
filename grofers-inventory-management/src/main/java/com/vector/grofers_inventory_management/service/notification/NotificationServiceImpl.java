package com.vector.grofers_inventory_management.service.notification;

import com.vector.grofers_inventory_management.entity.Manager;
import com.vector.grofers_inventory_management.entity.Product;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Override
    public void sendAlertToManagerForProduct(Manager manager, Product product) {
        System.out.println("manager "+ manager.getName()+"\n product " + product.getName() + " id - "+ product.getId()+ " has only quantity-"+product.getQuantity());
    }
}
