package org.example.shop.core.domain.order;

import org.example.shop.core.common.NotFoundException;

public class OrderNotFoundException extends NotFoundException {

    public OrderNotFoundException(long id) {
        super(id+ "번 주문이 존재하지 않습니다.");
    }
}
