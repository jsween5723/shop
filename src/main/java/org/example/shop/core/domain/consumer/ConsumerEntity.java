package org.example.shop.core.domain.consumer;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity(name = "consumers")
public class ConsumerEntity {
    @Id @GeneratedValue
    private Long id;
    private String name;
    private String contactNumber;
    private String address;

    public ConsumerEntity() {
    }

    private ConsumerEntity(String name, String contactNumber, String address) {
        this.name = name;
        this.contactNumber = contactNumber;
        this.address = address;
    }
    ConsumerEntity(CreateConsumer consumer) {
        name = consumer.name();
        contactNumber = consumer.contactNumber();
        address = consumer.address();
    }

    void modify(ModifyConsumer consumer) {
        name = consumer.name();
        contactNumber = consumer.contactNumber();
        address = consumer.address();
    }

    public ConsumerEntity(Long id) {
        this.id = id;
    }

    Consumer toDomain() {
        return new Consumer(id, name, contactNumber, address);
    }
}
