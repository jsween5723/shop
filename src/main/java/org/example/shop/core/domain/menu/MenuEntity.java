package org.example.shop.core.domain.menu;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity(name = "menus")
class MenuEntity {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String category;
    private int price;
    private String description;

    protected MenuEntity() {
    }

    private MenuEntity(String name, String category, int price, String description) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.description = description;
    }

    MenuEntity(CreateMenu createMenu) {
        this(createMenu.name(), createMenu.category(), createMenu.price(),
            createMenu.description());
    }

    void modify(ModifyMenu modifyMenu) {
        name = modifyMenu.name();
        category = modifyMenu.category();
        price = modifyMenu.price();
        description = modifyMenu.description();
    }

    Menu toDomain() {
        return new Menu(id, name, category, price, description);
    }
}
