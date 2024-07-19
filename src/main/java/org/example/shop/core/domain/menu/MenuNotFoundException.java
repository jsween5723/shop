package org.example.shop.core.domain.menu;

public class MenuNotFoundException extends RuntimeException {

    public MenuNotFoundException(long id) {
        super(id+ "번 메뉴가 존재하지 않습니다.");
    }
}
