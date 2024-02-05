package edu.bbte.softeng.ktim2145.spring.application.port.out;

import edu.bbte.softeng.ktim2145.spring.application.domain.entity.BaseEntity;

import java.util.Collection;

public interface PersistencePort<EntityT extends BaseEntity> {
    EntityT create(EntityT entityT);

    void delete(Long id);

    EntityT findById(Long id);

    Collection<EntityT> findAll();
}