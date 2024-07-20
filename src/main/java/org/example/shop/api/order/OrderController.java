package org.example.shop.api.order;

import java.util.List;
import org.example.shop.core.domain.order.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/orders")
public class OrderController {
    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @GetMapping
    public List<FindOrderResponse> findAll() {
        return service.findAll().stream().map(FindOrderResponse::new).toList();
    }

    @GetMapping("{id}")
    public FindOrderResponse findById(@PathVariable long id) {
        return new FindOrderResponse(service.findById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody CreateOrderRequest request) {
        service.create(request.toDomain());
    }

    @PatchMapping("{id}")
    public void modifyItems(@PathVariable long id, @RequestBody ModifyOrderRequest request) {
        service.modify(id, request.toDomain());
    }

    @PatchMapping("{id}/status")
    public void changeStatus(@PathVariable long id, @RequestBody ModifyOrderStatusRequest request) {
        service.changeState(id, request.status());
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable long id) {
        service.delete(id);
    }

}
