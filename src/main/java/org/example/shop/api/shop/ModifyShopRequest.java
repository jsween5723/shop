package org.example.shop.api.shop;

import org.example.shop.core.domain.shop.ModifyShop;

record ModifyShopRequest(String name, String address, String contactNumber) {
    ModifyShop toDomain() {
        return new ModifyShop(name, address, contactNumber);
    }
}
