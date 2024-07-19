package org.example.shop.api.consumer;

import java.util.List;
import org.example.shop.core.domain.consumer.ConsumerService;
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
@RequestMapping("api/consumers")
public class ConsumerController {

    private final ConsumerService service;

    public ConsumerController(ConsumerService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody CreateConsumerRequest request) {
        service.create(request.toDomain());
    }

    @GetMapping
    public List<FindConsumerResponse> findAll() {
        return service.findAll().stream().map(FindConsumerResponse::new).toList();
    }

    @GetMapping("{id}")
    public FindConsumerResponse findById(@PathVariable("id") long id) {
        return new FindConsumerResponse(service.findById(id));
    }

    @PutMapping("{id}")
    public void modify(@PathVariable("id") long id, @RequestBody ModifyConsumerRequest request) {
        service.modify(id, request.toDomain());
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") long id) {
        service.delete(id);
    }
}
