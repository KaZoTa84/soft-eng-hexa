package edu.bbte.softeng.ktim2145.spring.application.port.in;

import edu.bbte.softeng.ktim2145.spring.application.domain.entity.BaseEntity;
import edu.bbte.softeng.ktim2145.spring.util.annotation.UseCase;
import org.springframework.stereotype.Service;

import java.util.Collection;

@UseCase
public interface PurchaseUseCase<EntityT extends BaseEntity> {
    Collection<EntityT> getAllOintment();

    EntityT describeTheOintment(Long id);

    EntityT newOintment(EntityT entity);

    EntityT purchaseOintment(Long id, Double balance);
}
