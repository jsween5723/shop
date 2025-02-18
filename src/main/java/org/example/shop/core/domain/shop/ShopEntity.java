package org.example.shop.core.domain.shop;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity(name = "shops")
public class ShopEntity {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String contactNumber;
    private String address;

    protected ShopEntity() {
    }

    private ShopEntity(String name, String phoneNumber, String address) {
        this.name = name;
        this.contactNumber = phoneNumber;
        this.address = address;
    }

    ShopEntity(CreateShop createShop) {
        name = createShop.name();
        contactNumber = createShop.contactNumber();
        address = createShop.address();
    }

    public ShopEntity(long id) {
        this.id = id;
    }

    void modify(ModifyShop modifyShop) {
       name = modifyShop.name();
       contactNumber = modifyShop.contactNumber();
       address = modifyShop.address();
    }

    public Shop toDomain() {
        return new Shop(id, name, contactNumber, address);
    }
}
