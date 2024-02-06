package edu.bbte.softeng.ktim2145.spring.adapter.out.persistence.jpa;

import edu.bbte.softeng.ktim2145.spring.application.domain.entity.Ointment;
import edu.bbte.softeng.ktim2145.spring.application.port.out.OintmentPersistencePort;
import jakarta.validation.constraints.NotNull;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Profile("jpa")
public interface OintmentJpaPersistence extends OintmentPersistencePort, JpaRepository<Ointment, Long> {
    @Override
    void deleteById(@NotNull Long id);
}
