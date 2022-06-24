package com.godeltech.mastery.expertise.expertisemastery.web.mappers;

import com.godeltech.mastery.expertise.expertisemastery.persistence.entity.Expertise;
import com.godeltech.mastery.expertise.expertisemastery.service.dto.ExpertiseDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-24T04:51:59-0700",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
@Component
public class ExpertiseMapperImpl implements ExpertiseMapper {

    @Override
    public ExpertiseDto expertiseToExpertiseDto(Expertise expertise) {
        if ( expertise == null ) {
            return null;
        }

        ExpertiseDto.ExpertiseDtoBuilder expertiseDto = ExpertiseDto.builder();

        expertiseDto.id( expertise.getId() );
        expertiseDto.name( expertise.getName() );
        expertiseDto.expertiseGroup( expertise.getExpertiseGroup() );
        expertiseDto.deleted( expertise.isDeleted() );

        return expertiseDto.build();
    }

    @Override
    public Expertise expertiseDtoToExpertise(ExpertiseDto expertiseDto) {
        if ( expertiseDto == null ) {
            return null;
        }

        Expertise expertise = new Expertise();

        expertise.setId( expertiseDto.getId() );
        expertise.setName( expertiseDto.getName() );
        expertise.setExpertiseGroup( expertiseDto.getExpertiseGroup() );
        expertise.setDeleted( expertiseDto.isDeleted() );

        return expertise;
    }

    @Override
    public List<ExpertiseDto> toListDto(List<Expertise> expertise) {
        if ( expertise == null ) {
            return null;
        }

        List<ExpertiseDto> list = new ArrayList<ExpertiseDto>( expertise.size() );
        for ( Expertise expertise1 : expertise ) {
            list.add( expertiseToExpertiseDto( expertise1 ) );
        }

        return list;
    }

    @Override
    public void updateEntityToModel(Expertise target, ExpertiseDto source) {
        if ( source == null ) {
            return;
        }

        target.setName( source.getName() );
        target.setExpertiseGroup( source.getExpertiseGroup() );
        target.setDeleted( source.isDeleted() );
    }
}
