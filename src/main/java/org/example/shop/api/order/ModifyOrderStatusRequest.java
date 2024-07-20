package org.example.shop.api.order;

import org.example.shop.core.domain.order.OrderStatus;

record ModifyOrderStatusRequest(OrderStatus status) {

}
