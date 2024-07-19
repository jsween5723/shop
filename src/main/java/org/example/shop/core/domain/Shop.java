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

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getAddress() {
        return address;
    }
}
