package org.example.shop.core.domain.order;

import java.time.ZonedDateTime;
import java.util.LinkedHashSet;
import java.util.Set;
import org.example.shop.core.domain.consumer.Consumer;
import org.example.shop.core.domain.shop.Shop;

public class Order {
    private final long id;
    private final Consumer consumer;
    private final Shop shop;
    private final Set<OrderItem> items = new LinkedHashSet<>();
    private final ZonedDateTime createdAt;
    private OrderStatus status = OrderStatus.PENDING;
    private Integer totalPrice;
    Order(long id, Consumer consumer, Set<OrderItem> items, Shop shop, ZonedDateTime createdAt,
        Integer totalPrice) {
        this.id = id;
        this.consumer = consumer;
        this.shop = shop;
        this.createdAt = createdAt;
        this.totalPrice = totalPrice;
        this.items.addAll(items);
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public long getId() {
        return id;
    }

    public Consumer getConsumer() {
        return consumer;
    }

    public Shop getShop() {
        return shop;
    }

    public Set<OrderItem> getItems() {
        return items;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public OrderStatus getStatus() {
        return status;
    }
}
