package org.example.shop.core.domain.consumer;

class ConsumerNotFoundException extends RuntimeException {

    public ConsumerNotFoundException(long id) {
        super(id+ "번 고객이 존재하지 않습니다.");
    }
}
