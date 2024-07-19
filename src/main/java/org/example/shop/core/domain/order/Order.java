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
    Order(long id, Consumer consumer, Set<OrderItem> items, Shop shop, ZonedDateTime createdAt) {
        this.id = id;
        this.consumer = consumer;
        this.shop = shop;
        this.createdAt = createdAt;
        this.items.addAll(items);
    }
}
