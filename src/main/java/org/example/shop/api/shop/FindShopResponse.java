package org.example.shop.api.shop;

import org.example.shop.core.domain.Shop;

record FindShopResponse(long id, String name, String address, String contactNumber) {

    FindShopResponse(Shop shop) {
        this(shop.getId(), shop.getName(), shop.getAddress(), shop.getContactNumber());
    }
}
