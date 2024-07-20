package org.example.shop.core.domain.shop;

import org.example.shop.core.domain.common.NotFoundException;

public class ShopNotFoundException extends NotFoundException {

    public ShopNotFoundException(long id) {
        super(id+ "번 매장이 존재하지 않습니다.");
    }
}
