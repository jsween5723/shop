package org.example.shop.core.domain.menu;

import org.springframework.data.jpa.repository.JpaRepository;

interface MenuRepository extends JpaRepository<MenuEntity, Long>, MenuQueryRepository {
}
