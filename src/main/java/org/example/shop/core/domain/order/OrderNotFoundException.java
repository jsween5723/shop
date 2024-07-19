package org.example.shop.core.domain.order;

public class OrderNotFoundException extends RuntimeException {

    public OrderNotFoundException(long id) {
        super(id+ "번 주문이 존재하지 않습니다.");
    }
}
