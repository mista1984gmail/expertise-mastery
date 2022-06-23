package com.godeltech.mastery.expertise.expertisemastery.web.mappers;

import com.godeltech.mastery.expertise.expertisemastery.persistence.entity.Expertise;
import com.godeltech.mastery.expertise.expertisemastery.service.dto.ExpertiseDto;
import org.mapstruct.Mapper;

@Mapper
public interface ExpertiseMapper {

    ExpertiseDto expertiseToExpertiseDto (Expertise expertise);

    Expertise expertiseDtoToExpertise (ExpertiseDto expertiseDto);

}
