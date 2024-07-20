package org.example.shop.core.domain.shop;

import java.util.List;
import org.example.shop.api.shop.FindShopRevenueQuery;

interface ShopQueryRepository {
    List<ShopRevenue> findShopWithRevenue(FindShopRevenueQuery query);
}
