package org.example.shop.core.domain.menu;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;
import org.example.shop.api.menu.FindMenuQuery;
import org.springframework.stereotype.Repository;

@Repository
public class MenuQueryRepositoryImpl implements MenuQueryRepository {

    private final EntityManager entityManager;

    public MenuQueryRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public List<MenuEntity> findByQuery(FindMenuQuery query) {
        String sql = "select m from menus m";
        if (isExistCategory(query)) {
            sql += "where m.categoty = :category";
        }

        TypedQuery<MenuEntity> statement = entityManager.createQuery(sql, MenuEntity.class);
        if (isExistCategory(query)) {
            statement.setParameter("category", query.category());
        }
        return statement.getResultList();
    }

    @Override
    public List<RankMenu> rank3ByOrderCount() {
        String sql = "select m.id, m.category, m.name, m.price, m.description, count(m) as totalOrderNumber "
            + "from order_items oi join menus m "
            + "group by m.id order by totalOrderNumber DESC limit 3";
        return entityManager.createQuery(sql, RankMenu.class).getResultList();
    }

    private boolean isExistCategory(FindMenuQuery query) {
        return query.category() != null && !query.category().isBlank();
    }
}
