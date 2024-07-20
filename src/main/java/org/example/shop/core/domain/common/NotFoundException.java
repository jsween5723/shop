package org.example.shop.core.domain.common;

public class NotFoundException extends BusinessException {

    public NotFoundException(String message) {
        super(message, "NOT_FOUND");
    }
}
