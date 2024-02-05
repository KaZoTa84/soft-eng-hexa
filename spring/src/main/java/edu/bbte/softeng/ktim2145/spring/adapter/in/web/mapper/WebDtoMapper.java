package edu.bbte.softeng.ktim2145.spring.adapter.in.web.mapper;

import edu.bbte.softeng.ktim2145.spring.adapter.in.web.dto.WebCreateDto;
import edu.bbte.softeng.ktim2145.spring.adapter.in.web.dto.WebDetailedDto;
import edu.bbte.softeng.ktim2145.spring.adapter.in.web.dto.WebReducedDto;
import edu.bbte.softeng.ktim2145.spring.application.domain.entity.Ointment;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;

import java.util.Collection;

@Mapper(componentModel = "spring")
public abstract class WebDtoMapper {
    @IterableMapping(elementTargetType = WebReducedDto.class)
    public abstract Collection<WebReducedDto> modelsToWebReducedDtos(Iterable<Ointment> models);

    public abstract WebDetailedDto modelToWebDetailedDto(Ointment ointment);

    public abstract Ointment createDtoToModel(WebCreateDto createDto);
}
