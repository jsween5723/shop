package org.example.shop.api.menu;

import org.example.shop.core.domain.menu.RankMenu;

record RankMenuResponse(long id, String category, String name, String description, int price, int totalOrderNumber) {
    RankMenuResponse(RankMenu rankMenu) {
        this(rankMenu.id(), rankMenu.category(), rankMenu.name(), rankMenu.description(),
            rankMenu.price(), rankMenu.totalOrderNumber());
    }
}
