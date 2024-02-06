package edu.bbte.softeng.ktim2145.spring.adapter.in.web.mapper;

import edu.bbte.softeng.ktim2145.spring.adapter.in.web.dto.WebCreateDto;
import edu.bbte.softeng.ktim2145.spring.adapter.in.web.dto.WebDetailedDto;
import edu.bbte.softeng.ktim2145.spring.adapter.in.web.dto.WebReducedDto;
import edu.bbte.softeng.ktim2145.spring.application.domain.entity.Ointment;
import java.util.ArrayList;
import java.util.Collection;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-06T15:15:41+0200",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.4.jar, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class WebDtoMapperImpl extends WebDtoMapper {

    @Override
    public Collection<WebReducedDto> modelsToWebReducedDtos(Iterable<Ointment> models) {
        if ( models == null ) {
            return null;
        }

        Collection<WebReducedDto> collection = new ArrayList<WebReducedDto>();
        for ( Ointment ointment : models ) {
            collection.add( ointmentToWebReducedDto( ointment ) );
        }

        return collection;
    }

    @Override
    public WebDetailedDto modelToWebDetailedDto(Ointment ointment) {
        if ( ointment == null ) {
            return null;
        }

        WebDetailedDto webDetailedDto = new WebDetailedDto();

        webDetailedDto.setId( ointment.getId() );
        webDetailedDto.setName( ointment.getName() );
        webDetailedDto.setBrand( ointment.getBrand() );
        webDetailedDto.setExpiration( ointment.getExpiration() );
        webDetailedDto.setPrice( ointment.getPrice() );
        webDetailedDto.setDescription( ointment.getDescription() );

        return webDetailedDto;
    }

    @Override
    public Ointment createDtoToModel(WebCreateDto createDto) {
        if ( createDto == null ) {
            return null;
        }

        Ointment ointment = new Ointment();

        ointment.setName( createDto.getName() );
        ointment.setBrand( createDto.getBrand() );
        ointment.setExpiration( createDto.getExpiration() );
        ointment.setDescription( createDto.getDescription() );
        ointment.setPrice( createDto.getPrice() );

        return ointment;
    }

    protected WebReducedDto ointmentToWebReducedDto(Ointment ointment) {
        if ( ointment == null ) {
            return null;
        }

        WebReducedDto webReducedDto = new WebReducedDto();

        webReducedDto.setId( ointment.getId() );
        webReducedDto.setName( ointment.getName() );
        webReducedDto.setBrand( ointment.getBrand() );
        webReducedDto.setExpiration( ointment.getExpiration() );
        webReducedDto.setPrice( ointment.getPrice() );

        return webReducedDto;
    }
}
