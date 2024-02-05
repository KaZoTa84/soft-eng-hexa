package edu.bbte.softeng.ktim2145.spring.application.domain.service;

import edu.bbte.softeng.ktim2145.spring.application.port.in.PurchaseUseCase;
import edu.bbte.softeng.ktim2145.spring.application.port.out.OintmentPersistencePort;
import edu.bbte.softeng.ktim2145.spring.util.exception.ServiceException;
import edu.bbte.softeng.ktim2145.spring.application.domain.entity.Ointment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.concurrent.atomic.AtomicLong;

@Slf4j
@Service
public class PurchaseService implements PurchaseUseCase<Ointment> {
    @Autowired
    private OintmentPersistencePort ointmentRepository;
    private AtomicLong newId = new AtomicLong(1L);

    @Override
    public Ointment newOintment(Ointment ointment) {
        Long id = newId.getAndIncrement();
        Ointment newProperty = new Ointment(ointment.getName(),
                ointment.getBrand(),
                ointment.getExpiration(),
                ointment.getDescription(),
                ointment.getPrice());
        newProperty.setId(id);

        log.info("Ointment created.");
        return ointmentRepository.create(newProperty);
    }

    @Override
    public Ointment describeTheOintment(Long id) {
        log.info("Ointment sent to client.");
        return ointmentRepository.findById(id);
    }

    @Override
    public Collection<Ointment> getAllOintment() {
        log.info("All Ointments sent to client.");
        return ointmentRepository.findAll();
    }

    @Override
    public Ointment purchaseOintment(Long id, Double balance) {
        Ointment ointment = ointmentRepository.findById(id);

        if (ointment.getPrice() > balance) {
            throw new ServiceException("You don't have enough money to buy the product!");
        }

        ointmentRepository.delete(id);
        log.info("Ointment purchased successfully!");
        return ointment;
    }
}
