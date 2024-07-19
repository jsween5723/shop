package org.example.shop.core.domain.consumer;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ConsumerService {

    private final ConsumerRepository repository;

    public ConsumerService(ConsumerRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public void create(CreateConsumer consumer) {
        repository.save(new ConsumerEntity(consumer));
    }

    @Transactional
    public void delete(long id) {
        ConsumerEntity entity = getEntityById(id);
        repository.delete(entity);
    }

    private ConsumerEntity getEntityById(long id) {
        return repository.findById(id).orElseThrow(() -> new ConsumerNotFoundException(id));
    }

    @Transactional
    public void modify(long id, ModifyConsumer consumer) {
        ConsumerEntity entity = getEntityById(id);
        entity.modify(consumer);
    }

    public Consumer findById(long id) {
        return getEntityById(id).toDomain();
    }

    public List<Consumer> findAll() {
        return repository.findAll().stream().map(ConsumerEntity::toDomain).toList();
    }
}
