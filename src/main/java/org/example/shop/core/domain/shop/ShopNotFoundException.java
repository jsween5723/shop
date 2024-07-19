package org.example.shop.core.domain.shop;

public class ShopNotFoundException extends RuntimeException {

    public ShopNotFoundException(long id) {
        super(id+ "번 매장이 존재하지 않습니다.");
    }
}
