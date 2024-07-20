package org.example.shop.core.domain.shop;

import java.util.List;
import org.example.shop.api.shop.FindShopRevenueQuery;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ShopService {

    private final ShopRepository repository;

    public ShopService(ShopRepository repository) {
        this.repository = repository;
    }

    public Shop findById(long id) {
        ShopEntity shopEntity = getShopEntity(id);
        return shopEntity.toDomain();
    }

    @Transactional
    public void delete(long shopId) {
        ShopEntity shopEntity = getShopEntity(shopId);
        repository.delete(shopEntity);
    }

    @Transactional()
    public void create(CreateShop createShop) {
        ShopEntity shopEntity = new ShopEntity(createShop);
        repository.save(shopEntity);
    }

    private ShopEntity getShopEntity(long shopId) {
        return repository.findById(shopId).orElseThrow(() -> new ShopNotFoundException(shopId));
    }

    @Transactional
    public void modify(long shopId, ModifyShop modifyShop) {
        ShopEntity shopEntity = getShopEntity(shopId);
        shopEntity.modify(modifyShop);
    }

    public List<Shop> findAll() {
        return repository.findAll().stream().map(ShopEntity::toDomain).toList();
    }

    public List<ShopRevenue> findShopRevenue(FindShopRevenueQuery query) {
        return repository.findShopWithRevenue(query);
    }
}
