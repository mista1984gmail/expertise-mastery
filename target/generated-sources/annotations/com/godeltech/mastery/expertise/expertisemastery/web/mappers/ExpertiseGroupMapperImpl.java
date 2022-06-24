package com.godeltech.mastery.expertise.expertisemastery.web.mappers;

import com.godeltech.mastery.expertise.expertisemastery.persistence.entity.Expertise;
import com.godeltech.mastery.expertise.expertisemastery.persistence.entity.ExpertiseGroup;
import com.godeltech.mastery.expertise.expertisemastery.service.dto.ExpertiseGroupDto;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-24T04:51:49-0700",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
@Component
public class ExpertiseGroupMapperImpl implements ExpertiseGroupMapper {

    @Override
    public ExpertiseGroupDto expertiseGroupToExpertiseGroupDto(ExpertiseGroup expertiseGroup) {
        if ( expertiseGroup == null ) {
            return null;
        }

        ExpertiseGroupDto.ExpertiseGroupDtoBuilder expertiseGroupDto = ExpertiseGroupDto.builder();

        expertiseGroupDto.id( expertiseGroup.getId() );
        expertiseGroupDto.name( expertiseGroup.getName() );
        expertiseGroupDto.deleted( expertiseGroup.isDeleted() );
        Set<Expertise> set = expertiseGroup.getExpertise();
        if ( set != null ) {
            expertiseGroupDto.expertise( new LinkedHashSet<Expertise>( set ) );
        }

        return expertiseGroupDto.build();
    }

    @Override
    public ExpertiseGroup expertiseGroupDtoToExpertiseGroup(ExpertiseGroupDto expertiseGroupDto) {
        if ( expertiseGroupDto == null ) {
            return null;
        }

        ExpertiseGroup expertiseGroup = new ExpertiseGroup();

        Set<Expertise> set = expertiseGroupDto.getExpertise();
        if ( set != null ) {
            expertiseGroup.setExpertise( new LinkedHashSet<Expertise>( set ) );
        }
        expertiseGroup.setId( expertiseGroupDto.getId() );
        expertiseGroup.setName( expertiseGroupDto.getName() );
        expertiseGroup.setDeleted( expertiseGroupDto.isDeleted() );

        return expertiseGroup;
    }

    @Override
    public List<ExpertiseGroupDto> toListDto(List<ExpertiseGroup> expertiseGroups) {
        if ( expertiseGroups == null ) {
            return null;
        }

        List<ExpertiseGroupDto> list = new ArrayList<ExpertiseGroupDto>( expertiseGroups.size() );
        for ( ExpertiseGroup expertiseGroup : expertiseGroups ) {
            list.add( expertiseGroupToExpertiseGroupDto( expertiseGroup ) );
        }

        return list;
    }

    @Override
    public void updateEntityToModel(ExpertiseGroup target, ExpertiseGroupDto source) {
        if ( source == null ) {
            return;
        }

        if ( target.getExpertise() != null ) {
            Set<Expertise> set = source.getExpertise();
            if ( set != null ) {
                target.getExpertise().clear();
                target.getExpertise().addAll( set );
            }
            else {
                target.setExpertise( null );
            }
        }
        else {
            Set<Expertise> set = source.getExpertise();
            if ( set != null ) {
                target.setExpertise( new LinkedHashSet<Expertise>( set ) );
            }
        }
        target.setName( source.getName() );
        target.setDeleted( source.isDeleted() );
    }
}
