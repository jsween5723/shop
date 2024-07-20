package org.example.shop.api.order;

import java.time.ZonedDateTime;
import java.util.Set;
import java.util.stream.Collectors;
import org.example.shop.core.domain.consumer.Consumer;
import org.example.shop.core.domain.menu.Menu;
import org.example.shop.core.domain.order.Order;
import org.example.shop.core.domain.order.OrderItem;
import org.example.shop.core.domain.order.OrderStatus;
import org.example.shop.core.domain.shop.Shop;

record FindOrderResponse(long id, ConsumerResponse consumer, ShopResponse shop,
                         Set<OrderItemResponse> items, Integer totalPrice, OrderStatus status,
                         ZonedDateTime createdAt) {

    FindOrderResponse(Order order) {
        this(order.getId(), new ConsumerResponse(order.getConsumer()),
            new ShopResponse(order.getShop()),
            order.getItems().stream().map(OrderItemResponse::new).collect(Collectors.toSet()),
            order.getTotalPrice(), order.getStatus(), order.getCreatedAt());
    }

    private record ConsumerResponse(long id, String name) {

        ConsumerResponse(Consumer consumer) {
            this(consumer.getId(), consumer.getName());
        }
    }

    private record ShopResponse(long id, String name) {

        ShopResponse(Shop shop) {
            this(shop.getId(), shop.getName());
        }
    }

    private record OrderItemResponse(MenuResponse menu, int qty) {

        OrderItemResponse(OrderItem item) {
            this(new MenuResponse(item.getMenu()), item.getQty());
        }
    }

    private record MenuResponse(long id, String name, int price) {

        MenuResponse(Menu menu) {
            this(menu.getId(), menu.getName(), menu.getPrice());
        }
    }
}
