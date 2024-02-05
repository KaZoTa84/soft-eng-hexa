package edu.bbte.softeng.ktim2145.spring.application.port.out;

import edu.bbte.softeng.ktim2145.spring.application.domain.entity.BaseEntity;

import java.util.Collection;
import java.util.Optional;

public interface PersistencePort<EntityT extends BaseEntity> {
    EntityT save(EntityT entityT);

    void deleteById(Long id);

    Optional<EntityT> findById(Long id);

    Collection<EntityT> findAll();
}