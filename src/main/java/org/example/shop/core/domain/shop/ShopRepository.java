package org.example.shop.core.domain.shop;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepository extends JpaRepository<ShopEntity, Long>, ShopQueryRepository{

}
