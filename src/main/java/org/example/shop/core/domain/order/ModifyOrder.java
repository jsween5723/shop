package org.example.shop.core.domain.order;

import java.util.Set;

public record ModifyOrder(Set<CreateOrderItem> items) {

}
