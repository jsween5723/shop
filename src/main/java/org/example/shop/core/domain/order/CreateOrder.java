package org.example.shop.core.domain.order;

import java.util.Set;

public record CreateOrder(long consumerId, long shopId, Set<CreateOrderItem> items) {

}
