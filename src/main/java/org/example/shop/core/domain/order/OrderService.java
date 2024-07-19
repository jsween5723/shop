package org.example.shop.core.domain.order;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    public void create(CreateOrder createOrder) {

    }
    public void delete(long orderId) {

    }
    public void modify(long id, ModifyOrder modifyOrder) {

    }

    public Order findById(long orderId) {
        return null;
    }

    private OrderEntity getEntityById(long orderId) {
        return null;
    }

    public List<Order> findAll() {
        return null;
    }

    public void changeState(long orderId, OrderStatus status) {

    }
}
