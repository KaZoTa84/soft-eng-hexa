package edu.bbte.softeng.ktim2145.spring.adapter.out.persistence;

import edu.bbte.softeng.ktim2145.spring.adapter.out.persistence.dto.PersistenceDto;
import edu.bbte.softeng.ktim2145.spring.adapter.out.persistence.mapper.PersistenceDtoMapper;
import edu.bbte.softeng.ktim2145.spring.application.port.out.OintmentPersistencePort;
import edu.bbte.softeng.ktim2145.spring.application.domain.entity.Ointment;
import edu.bbte.softeng.ktim2145.spring.util.annotation.PersistenceAdapter;
import edu.bbte.softeng.ktim2145.spring.util.exception.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@PersistenceAdapter
@Repository
@Profile("in-memory")
public class OintmentInMemoryPersistence implements OintmentPersistencePort {
    @Autowired
    protected PersistenceDtoMapper persistenceDtoMapper;

    protected Map<Long, PersistenceDto> entities = new ConcurrentHashMap<>();

    @Override
    public Ointment create(Ointment entity) {
        PersistenceDto dto = persistenceDtoMapper.modelToDto(entity);
        entities.put(entity.getId(), dto);
        return persistenceDtoMapper.dtoToModel(entities.get(entity.getId()));
    }

    @Override
    public Ointment findById(Long id) {
        if (!entities.containsKey(id)) {
            throw new NotFoundException("The requested Id doesn't exist!");
        }

        return persistenceDtoMapper.dtoToModel(entities.get(id));
    }

    @Override
    public Collection<Ointment> findAll() {
        if (entities.isEmpty()) {
            throw new NotFoundException("There is no entities in the database!");
        }

        return persistenceDtoMapper.dtosToModels(entities.values());
    }

    @Override
    public void delete(Long id) {
        if (!entities.containsKey(id)) {
            throw new NotFoundException("The requested Id doesn't exist!");
        }

        entities.remove(id);
    }
}
