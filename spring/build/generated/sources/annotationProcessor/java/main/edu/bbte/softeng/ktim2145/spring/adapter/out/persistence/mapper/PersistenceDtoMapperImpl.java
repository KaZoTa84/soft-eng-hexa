package edu.bbte.softeng.ktim2145.spring.adapter.out.persistence.mapper;

import edu.bbte.softeng.ktim2145.spring.adapter.out.persistence.dto.PersistenceDto;
import edu.bbte.softeng.ktim2145.spring.application.domain.entity.Ointment;
import java.util.ArrayList;
import java.util.Collection;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-20T18:15:08+0200",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.4.jar, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class PersistenceDtoMapperImpl extends PersistenceDtoMapper {

    @Override
    public Collection<Ointment> dtosToModels(Iterable<PersistenceDto> dtos) {
        if ( dtos == null ) {
            return null;
        }

        Collection<Ointment> collection = new ArrayList<Ointment>();
        for ( PersistenceDto persistenceDto : dtos ) {
            collection.add( dtoToModel( persistenceDto ) );
        }

        return collection;
    }

    @Override
    public Ointment dtoToModel(PersistenceDto dto) {
        if ( dto == null ) {
            return null;
        }

        Ointment ointment = new Ointment();

        ointment.setId( dto.getId() );
        ointment.setName( dto.getName() );
        ointment.setBrand( dto.getBrand() );
        ointment.setExpiration( dto.getExpiration() );
        ointment.setDescription( dto.getDescription() );
        ointment.setPrice( dto.getPrice() );

        return ointment;
    }

    @Override
    public PersistenceDto modelToDto(Ointment model) {
        if ( model == null ) {
            return null;
        }

        PersistenceDto persistenceDto = new PersistenceDto();

        persistenceDto.setId( model.getId() );
        persistenceDto.setName( model.getName() );
        persistenceDto.setBrand( model.getBrand() );
        persistenceDto.setExpiration( model.getExpiration() );
        persistenceDto.setPrice( model.getPrice() );
        persistenceDto.setDescription( model.getDescription() );

        return persistenceDto;
    }
}
