package org.example.shop.api.consumer;

import org.example.shop.core.domain.consumer.CreateConsumer;

record CreateConsumerRequest(String name, String contactNumber, String address) {
    CreateConsumer toDomain() {
        return new CreateConsumer(name, contactNumber, address);
    }
}
