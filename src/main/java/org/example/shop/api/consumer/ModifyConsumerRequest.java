package org.example.shop.api.consumer;

import org.example.shop.core.domain.consumer.ModifyConsumer;

record ModifyConsumerRequest(String name, String contactNumber, String address) {
    ModifyConsumer toDomain() {
        return new ModifyConsumer(name, contactNumber, address);
    }
}
