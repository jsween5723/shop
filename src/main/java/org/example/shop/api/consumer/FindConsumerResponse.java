package org.example.shop.api.consumer;

import org.example.shop.core.domain.consumer.Consumer;

record FindConsumerResponse(long id, String name, String contactNumber, String address) {
    FindConsumerResponse(Consumer consumer) {
        this(consumer.getId(), consumer.getName(), consumer.getContactNumber(),
            consumer.getAddress());
    }
}
