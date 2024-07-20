package org.example.shop.api.order;

import java.util.Set;
import java.util.stream.Collectors;
import org.example.shop.core.domain.order.CreateOrder;
import org.example.shop.core.domain.order.CreateOrderItem;

record CreateOrderRequest(long consumerId, long shopId, Set<CreateOrderItemRequst> items) {

    CreateOrder toDomain() {
        return new CreateOrder(consumerId, shopId,
            items.stream().map(CreateOrderItemRequst::toDoamin).collect(Collectors.toSet()));
    }

    private record CreateOrderItemRequst(long menuId, int qty) {

        CreateOrderItem toDoamin() {
            return new CreateOrderItem(menuId, qty);
        }
    }
}
