package org.example.shop.core.domain.menu;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;
import org.example.shop.api.menu.FindMenuQuery;

public class MenuJpqlRepository implements MenuQueryRepository {

    private final EntityManager entityManager;

    public MenuJpqlRepository(EntityManager entityManager) {
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

    private boolean isExistCategory(FindMenuQuery query) {
        return query.category() != null && !query.category().isBlank();
    }
}
