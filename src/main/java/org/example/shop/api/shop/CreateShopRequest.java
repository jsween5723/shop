package org.example.shop.api.shop;

import org.example.shop.core.domain.shop.CreateShop;
record CreateShopRequest(String name, String address, String contactNumber) {
    CreateShop toDomain() {
        return new CreateShop(name, address, contactNumber);
    }
}
