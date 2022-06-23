package com.godeltech.mastery.expertise.expertisemastery.web.mappers;

import com.godeltech.mastery.expertise.expertisemastery.persistence.entity.Expertise;
import com.godeltech.mastery.expertise.expertisemastery.service.dto.ExpertiseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper
public interface ExpertiseMapper {

    ExpertiseDto expertiseToExpertiseDto (Expertise expertise);

    Expertise expertiseDtoToExpertise (ExpertiseDto expertiseDto);
    List<ExpertiseDto> toListDto(List<Expertise> expertise);
    @Mapping(target = "id", ignore = true)
    void updateEntityToModel(@MappingTarget Expertise target, ExpertiseDto source);

}
