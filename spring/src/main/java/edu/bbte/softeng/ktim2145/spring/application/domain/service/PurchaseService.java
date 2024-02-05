package edu.bbte.softeng.ktim2145.spring.application.domain.service;

import edu.bbte.softeng.ktim2145.spring.application.port.in.PurchaseUseCase;
import edu.bbte.softeng.ktim2145.spring.application.port.out.OintmentPersistencePort;
import edu.bbte.softeng.ktim2145.spring.util.annotation.UseCase;
import edu.bbte.softeng.ktim2145.spring.util.exception.NotFoundException;
import edu.bbte.softeng.ktim2145.spring.util.exception.ServiceException;
import edu.bbte.softeng.ktim2145.spring.application.domain.entity.Ointment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Slf4j
@Service
public class PurchaseService implements PurchaseUseCase<Ointment> {
    @Autowired
    private OintmentPersistencePort ointmentRepository;

    @Override
    public Ointment newOintment(Ointment ointment) {
        log.info("Ointment created.");
        return ointmentRepository.save(ointment);
    }

    @Override
    public Ointment describeTheOintment(Long id) {
        log.info("Ointment sent to client.");
        Optional<Ointment> ointment = ointmentRepository.findById(id);

        if (ointment.isPresent()) {
            return ointment.get();
        }

        throw new NotFoundException("Entity not found!");
    }

    @Override
    public Collection<Ointment> getAllOintment() {
        log.info("All Ointments sent to client.");
        return ointmentRepository.findAll();
    }

    @Override
    public Ointment purchaseOintment(Long id, Double balance) {
        Optional<Ointment> ointment = ointmentRepository.findById(id);

        if (ointment.isPresent()) {
            if (ointment.get().getPrice() > balance) {
                throw new ServiceException("You don't have enough money to buy the product!");
            }

            ointmentRepository.deleteById(id);
            log.info("Ointment purchased successfully!");
            return ointment.get();
        }

        throw new NotFoundException("Entity not found!");
    }
}
