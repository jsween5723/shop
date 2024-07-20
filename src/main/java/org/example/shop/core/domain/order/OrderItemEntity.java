package org.example.shop.core.domain.order;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.example.shop.core.domain.menu.MenuEntity;

@Entity(name = "order_items")
class OrderItemEntity {
    @Id @GeneratedValue
    private Long id;

    @JoinColumn(name = "order_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private OrderEntity order;

    @JoinColumn(name = "menu_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private MenuEntity menu;
    private int qty;

    protected OrderItemEntity() {
    }

    OrderItemEntity(CreateOrderItem item) {
        menu = new MenuEntity(item.menuId());
        qty = item.qty();
    }


    int getPrice() {
        return menu.getPrice() * qty;
    }

    OrderItem toDomain() {
        return new OrderItem(menu.toDomain(), qty);
    }
}
