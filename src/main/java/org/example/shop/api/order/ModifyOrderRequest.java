package org.example.shop.api.order;

import java.util.Set;
import java.util.stream.Collectors;
import org.example.shop.core.domain.order.ModifyOrder;
import org.example.shop.core.domain.order.ModifyOrderItem;

record ModifyOrderRequest(Set<ModifyOrderItemRequst> items) {

    ModifyOrder toDomain() {
        return new ModifyOrder(
            items.stream().map(ModifyOrderItemRequst::toDoamin).collect(Collectors.toSet()));
    }

    private record ModifyOrderItemRequst(long menuId, int qty) {

        ModifyOrderItem toDoamin() {
            return new ModifyOrderItem(menuId, qty);
        }
    }
}
