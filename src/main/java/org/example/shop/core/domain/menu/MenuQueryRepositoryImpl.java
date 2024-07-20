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
        String sql = "select m from menus m ";
        if (isExistCategory(query)) {
            sql += "where m.category = :category";
        }

        TypedQuery<MenuEntity> statement = entityManager.createQuery(sql, MenuEntity.class);
        if (isExistCategory(query)) {
            statement.setParameter("category", query.category());
        }
        return statement.getResultList();
    }

    @Override
    public List<RankMenu> rank3ByOrderCount() {
        String sql = "select new org.example.shop.core.domain.menu.RankMenu(m.id, m.category, m.name, m.description, m.price, cast(count(oi) as int)) "
            + "from order_items oi right join menus m on oi.menu.id = m.id "
            + "group by m.id order by count(m) DESC limit 3";
        return entityManager.createQuery(sql, RankMenu.class).getResultList();
    }

    private boolean isExistCategory(FindMenuQuery query) {
        return query.category() != null && !query.category().isBlank();
    }
}
