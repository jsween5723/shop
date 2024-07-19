package org.example.shop.core.domain;

public class Shop {
    private final long id;
    private String name;
    private String contactNumber;
    private String address;

    Shop(long id, String name, String phoneNumber, String address) {
        this.id = id;
        this.name = name;
        this.contactNumber = phoneNumber;
        this.address = address;
    }


}
