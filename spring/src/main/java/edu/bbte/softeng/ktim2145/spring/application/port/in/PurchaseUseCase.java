package edu.bbte.softeng.ktim2145.spring.application.port.in;

import edu.bbte.softeng.ktim2145.spring.application.domain.entity.BaseEntity;
import edu.bbte.softeng.ktim2145.spring.util.annotation.UseCase;

import java.util.Collection;

@UseCase
public interface PurchaseUseCase<T extends BaseEntity> {
    Collection<T> getAllOintment();

    T describeTheOintment(Long id);

    T newOintment(T entity);

    T purchaseOintment(Long id, Double balance);
}
