package org.example.shop.core.domain.menu;

import java.util.List;
import org.example.shop.api.menu.FindMenuQuery;

public interface MenuQueryRepository {
    List<MenuEntity> findByQuery(FindMenuQuery query);
}
