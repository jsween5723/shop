package org.example.shop.core.domain.shop;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;
import org.example.shop.api.shop.FindShopRevenueQuery;
import org.springframework.stereotype.Repository;

@Repository
public class ShopQueryRepositoryImpl implements ShopQueryRepository {

    private final EntityManager entityManager;

    public ShopQueryRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<ShopRevenue> findShopWithRevenue(FindShopRevenueQuery query) {
        String sql = "select new org.example.shop.core.domain.shop.ShopRevenue(s.id, s.name, s.address, s.contactNumber, cast(coalesce(sum(o.totalPrice), 0) as int ))  from orders o right join shops s on o.shop.id = s.id group by s.id";
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
        TypedQuery<ShopRevenue> statement = entityManager.createQuery(sql, ShopRevenue.class);
        if (query.from() != null) {
            statement.setParameter("from", query.from());
        }
        if (query.to() != null) {
            statement.setParameter("to", query.to());
        }
        return statement.getResultList();
    }

}
