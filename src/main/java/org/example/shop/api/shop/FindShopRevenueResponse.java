package org.example.shop.api.shop;

import java.time.ZonedDateTime;
import java.util.List;
import org.example.shop.core.domain.shop.ShopRevenue;

record FindShopRevenueResponse(ZonedDateTime from, ZonedDateTime to,
                               List<ShopRevenueResponse> shops) {

    FindShopRevenueResponse(FindShopRevenueQuery query, List<ShopRevenue> revenues) {
        this(query.from(), query.to(), revenues.stream().map(ShopRevenueResponse::new).toList());
    }

    private record ShopRevenueResponse(long id, String name, String address, String contactNumber,
                               int revenue) {

        ShopRevenueResponse(ShopRevenue revenue) {
            this(revenue.id(), revenue.name(), revenue.address(), revenue.contactNumber(),
                revenue.revenue());
        }
    }
}
