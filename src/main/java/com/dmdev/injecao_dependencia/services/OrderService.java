package com.dmdev.injecao_dependencia.services;

import com.dmdev.injecao_dependencia.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    ShippingService shippingService;

    public double total(Order order) {
        double totalDiscount = order.getBasic() * order.getDiscount() / 100;
        return order.getBasic() - totalDiscount + shippingService.shipment(order);
    }

}
