package org.example.shop.api.menu;

import org.example.shop.core.domain.menu.ModifyMenu;

record ModifyMenuRequest(String name, String category, int price, String description) {
    ModifyMenu toDomain() {
        return new ModifyMenu(name, category, price, description);
    }
}
