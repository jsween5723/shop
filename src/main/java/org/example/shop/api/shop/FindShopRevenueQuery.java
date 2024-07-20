package org.example.shop.api.shop;

import java.time.ZonedDateTime;

public record FindShopRevenueQuery(ZonedDateTime from, ZonedDateTime to) {

}
