package org.example.shop.core.common;

public class BusinessException extends RuntimeException {
    public final String code;

    public BusinessException(String message, String code) {
        super(message);
        this.code = code;
    }
}
