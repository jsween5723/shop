package org.example.shop.core.domain.consumer;

import org.example.shop.core.common.NotFoundException;

public class ConsumerNotFoundException extends NotFoundException {

    public ConsumerNotFoundException(long id) {
        super(id+ "번 고객이 존재하지 않습니다.");
    }
}
