package org.example.shop.core.domain;

public class Shop {
    private final long id;
    private String name;
    private String phoneNumber;
    private String address;

    private Shop(long id, String name, String phoneNumber, String address) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }


}
