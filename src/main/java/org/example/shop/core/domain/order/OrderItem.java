package org.example.shop.core.domain.order;

import org.example.shop.core.domain.menu.Menu;

public class OrderItem {

    private final Menu menu;
    private final int qty;

    OrderItem(long id, Menu menu, int qty) {
        this.menu = menu;
        this.qty = qty;
    }
}
