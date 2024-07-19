package org.example.shop.core.domain.menu;

public class Menu {
    private final long id;
    private String name;
    private String category;
    private int price;
    private String description;

    Menu(long id, String name, String category, int price, String description) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.description = description;
    }
}
