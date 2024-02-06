package edu.bbte.softeng.ktim2145.spring.adapter.out.persistence.mapper;

import edu.bbte.softeng.ktim2145.spring.adapter.out.persistence.dto.PersistenceDto;
import edu.bbte.softeng.ktim2145.spring.application.domain.entity.Ointment;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;

import java.util.Collection;

@Mapper(componentModel = "spring")
public abstract class PersistenceDtoMapper {
    @IterableMapping(elementTargetType = Ointment.class)
    public abstract Collection<Ointment> dtosToModels(Iterable<PersistenceDto> dtos);

    public abstract Ointment dtoToModel(PersistenceDto dto);

    public abstract PersistenceDto modelToDto(Ointment model);
}
