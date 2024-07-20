package org.example.shop.api.menu;

import java.util.List;
import org.example.shop.core.domain.menu.MenuService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/menus")
public class MenuController {
    private final MenuService service;

    public MenuController(MenuService service) {
        this.service = service;
    }

    @GetMapping
    public List<FindMenuResponse> findAll(FindMenuQuery request) {
        return service.findAll(request).stream().map(FindMenuResponse::new).toList();
    }

    @GetMapping("{id}")
    public FindMenuResponse findById(@PathVariable("id") long id) {
        return new FindMenuResponse(service.findById(id));
    }

    @PostMapping
    public void create(@RequestBody CreateMenuRequest request) {
        service.create(request.toDomain());
    }

    @PutMapping("{id}")
    public void modify(@PathVariable("id") long id, @RequestBody ModifyMenuRequest request) {
        service.modify(id, request.toDomain());
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") long id) {
        service.delete(id);
    }
}
