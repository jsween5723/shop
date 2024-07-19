package org.example.shop.api.menu;

import org.example.shop.core.domain.menu.CreateMenu;

record CreateMenuRequest(String name, String category, int price, String description) {
    CreateMenu toDomain() {
        return new CreateMenu(name, category, price, description);
    }
}
