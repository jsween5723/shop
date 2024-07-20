package org.example.shop.core.domain.menu;

import java.util.List;
import org.example.shop.api.menu.FindMenuQuery;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MenuService {

    private final MenuRepository repository;

    public MenuService(MenuRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public void create(CreateMenu createMenu) {
        repository.save(new MenuEntity(createMenu));
    }

    @Transactional
    public void delete(long menuId) {
        MenuEntity entity = getEntityById(menuId);
        repository.delete(entity);
    }

    private MenuEntity getEntityById(long menuId) {
        return repository.findById(menuId).orElseThrow(() -> new MenuNotFoundException(menuId));
    }

    @Transactional
    public void modify(long menuId, ModifyMenu modifyMenu) {
        MenuEntity entity = getEntityById(menuId);
        entity.modify(modifyMenu);
    }

    public Menu findById(long id) {
        return getEntityById(id).toDomain();
    }

    public List<Menu> findAll(FindMenuQuery query) {
        return repository.findByQuery(query).stream().map(MenuEntity::toDomain).toList();
    }

}
