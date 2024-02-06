package edu.bbte.softeng.ktim2145.spring.application.port.out;

import edu.bbte.softeng.ktim2145.spring.application.domain.entity.BaseEntity;

import java.util.Collection;
import java.util.Optional;

public interface PersistencePort<T extends BaseEntity> {
    T save(T entityT);

    void deleteById(Long id);

    Optional<T> findById(Long id);

    Collection<T> findAll();
}