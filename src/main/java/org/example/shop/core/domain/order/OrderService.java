package org.example.shop.core.domain.order;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    private final OrderRepository repository;

    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public void create(CreateOrder createOrder) {
        repository.save(new OrderEntity(createOrder));
    }

    @Transactional
    public void delete(long orderId) {
        OrderEntity entity = getEntityById(orderId);
        repository.delete(entity);
    }

    @Transactional
    public void modify(long id, ModifyOrder modifyOrder) {
        OrderEntity entity = getEntityById(id);
        entity.modify(modifyOrder);
    }

    public Order findById(long orderId) {
        return getEntityById(orderId).toDomain();
    }

    private OrderEntity getEntityById(long orderId) {
        return repository.findById(orderId).orElseThrow(() -> new OrderNotFoundException(orderId));
    }

    public List<Order> findAll() {
        return repository.findAll().stream().map(OrderEntity::toDomain).toList();
    }

    @Transactional
    public void changeState(long orderId, OrderStatus status) {
        OrderEntity entity = getEntityById(orderId);
        entity.changeStatus(status);
    }
}
