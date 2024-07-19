package org.example.shop.core.domain.consumer;

public class Consumer {
    private final long id;
    private String name;
    private String contactNumber;
    private String address;

    Consumer(long id, String name, String contactNumber, String address) {
        this.id = id;
        this.name = name;
        this.contactNumber = contactNumber;
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
