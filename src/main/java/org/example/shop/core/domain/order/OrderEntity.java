package org.example.shop.core.domain.order;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;
import org.example.shop.core.domain.consumer.ConsumerEntity;
import org.example.shop.core.domain.shop.ShopEntity;
import org.hibernate.annotations.BatchSize;

@Entity(name = "orders")
class OrderEntity {

    @Id
    @GeneratedValue
    private Long id;
    @JoinColumn(name = "customer_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private ConsumerEntity consumer;

    @JoinColumn(name = "shop_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private ShopEntity shop;

    //    OneToMany,Cascade 한 이유는~ 개별 생성, 수정, 삭제가 없이 Order라는 애그리거트 루트에 종속된 경우기 때문입니다~~
//    리스트 요소 전체가 하나의 값으로 취급되는 경우여서 사용했습니다.
    @OneToMany(mappedBy = "orderId", cascade = CascadeType.ALL)
    @BatchSize(size = 30) // N+1방지!!
    private Set<OrderItemEntity> items = new LinkedHashSet<>();

    private OrderEntity(ConsumerEntity consumer, ShopEntity shop, Set<OrderItemEntity> items) {
        this.consumer = consumer;
        this.shop = shop;
        this.items = items;
    }

    int calculateTotalPrice() {
        return items.stream().mapToInt(OrderItemEntity::getPrice).sum();
    }

    OrderEntity(CreateOrder createOrder) {
        consumer = new ConsumerEntity(createOrder.consumerId());
        shop = new ShopEntity(createOrder.shopId());
        items.addAll(
            createOrder.items().stream().map(OrderItemEntity::new).collect(Collectors.toSet()));
    }

    protected OrderEntity() {

    }
}
