package org.example.shop.api.order;

import java.util.Set;
import java.util.stream.Collectors;
import org.example.shop.api.order.CreateOrderRequest.CreateOrderItemRequst;
import org.example.shop.core.domain.order.ModifyOrder;

record ModifyOrderRequest(Set<CreateOrderItemRequst> items) {

    ModifyOrder toDomain() {
        return new ModifyOrder(
            items.stream().map(CreateOrderItemRequst::toDoamin).collect(Collectors.toSet()));
    }

}
