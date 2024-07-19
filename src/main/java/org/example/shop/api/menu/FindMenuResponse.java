package org.example.shop.api.menu;

import org.example.shop.core.domain.menu.Menu;

record FindMenuResponse(long id, String name, String category, int price, String description) {

    FindMenuResponse(Menu menu) {
        this(menu.getId(), menu.getName(), menu.getCategory(), menu.getPrice(),
            menu.getDescription());
    }
}
