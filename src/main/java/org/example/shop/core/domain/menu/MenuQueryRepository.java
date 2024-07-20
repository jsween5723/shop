package org.example.shop.core.domain.menu;

import java.util.List;
import org.example.shop.api.menu.FindMenuQuery;
import org.springframework.stereotype.Repository;

@Repository
interface MenuQueryRepository {
    List<MenuEntity> findByQuery(FindMenuQuery query);
    List<RankMenu> rank3ByOrderCount();
}
