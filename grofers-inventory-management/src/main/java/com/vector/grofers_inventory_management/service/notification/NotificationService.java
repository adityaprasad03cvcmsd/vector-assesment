package com.vector.grofers_inventory_management.service.notification;

import com.vector.grofers_inventory_management.entity.Manager;
import com.vector.grofers_inventory_management.entity.Product;

public interface NotificationService {

    void sendAlertToManagerForProduct(Manager manager, Product product);
}
