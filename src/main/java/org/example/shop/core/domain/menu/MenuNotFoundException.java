package org.example.shop.core.domain.menu;

import org.example.shop.core.common.NotFoundException;

class MenuNotFoundException extends NotFoundException {

    public MenuNotFoundException(long id) {
        super(id+ "번 메뉴가 존재하지 않습니다.");
    }
}
