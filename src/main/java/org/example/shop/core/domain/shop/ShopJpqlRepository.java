package org.example.shop.core.domain.shop;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;
import org.example.shop.api.shop.FindShopRevenueQuery;

public class ShopJpqlRepository implements ShopQueryRepository {

    private final EntityManager entityManager;

    public ShopJpqlRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<ShopRevenue> findShopWithRevenue(FindShopRevenueQuery query) {
        String sql = generateRevenueSql(query);
        TypedQuery<ShopRevenue> statement = entityManager.createQuery(sql, ShopRevenue.class);
        if (query.from() != null) {
            statement.setParameter("from", query.from());
        }
        if (query.to() != null) {
            statement.setParameter("to", query.to());
        }
        return statement.getResultList();
    }

    private String generateRevenueSql(FindShopRevenueQuery query) {
        String sql = "select s.id, s.name, s.address, s.contactNumber, sum(o.totalPrice) as revenue from shops s join orders o group by s.id";
        if (query.from() != null || query.to() != null) {
            sql += "having ";
        }
        if (query.from() != null) {
            sql += "o.completedAt > :from ";
        }
        if (query.from() != null && query.to() != null) {
            sql += "and ";
        }
        if (query.to() != null) {
            sql += "o.completedAt < :to";
        }
        return sql;
    }
}
