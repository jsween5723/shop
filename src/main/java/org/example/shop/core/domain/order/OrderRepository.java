package org.example.shop.core.domain.order;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

interface OrderRepository extends JpaRepository<OrderEntity, Long> {

    @Query("select o from orders o join fetch o.items i join fetch o.consumer join fetch o.shop join fetch i.menu")
    List<OrderEntity> findAll();

    List<OrderEntity> findByShopIdAndCreatedAtBetween(Long shopId, ZonedDateTime from,
        ZonedDateTime to);

    @Query("select o from orders o join o.items i join fetch o.consumer join fetch o.shop join fetch i.menu where o.id=:id")
    Optional<OrderEntity> findById(long id);
}
