package org.example.shop.api.shop;

import java.util.List;
import org.example.shop.core.domain.shop.ShopService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/shops")
public class ShopController {

    private final ShopService service;

    public ShopController(ShopService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody CreateShopRequest request) {
        service.create(request.toDomain());
    }

    @GetMapping
    public List<FindShopResponse> findAll() {
        return service.findAll().stream().map(FindShopResponse::new).toList();
    }

    @GetMapping("{id}")
    public FindShopResponse findById(@PathVariable("id") long id) {
        return new FindShopResponse(service.findById(id));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("id") long id) {
       service.delete(id);
    }

    @PutMapping("{id}")
    public void modify(@PathVariable("id") long id, @RequestBody ModifyShopRequest modifyShop) {
        service.modify(id, modifyShop.toDomain());
    }
}
