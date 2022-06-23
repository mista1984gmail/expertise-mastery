package com.godeltech.mastery.expertise.expertisemastery.web.mappers;

import com.godeltech.mastery.expertise.expertisemastery.persistence.entity.ExpertiseGroup;
import com.godeltech.mastery.expertise.expertisemastery.service.dto.ExpertiseGroupDto;
import org.mapstruct.Mapper;

@Mapper
public interface ExpertiseGroupMapper {

    ExpertiseGroupDto expertiseGroupToExpertiseGroupDto (ExpertiseGroup expertiseGroup);

    ExpertiseGroup expertiseGroupDtoToExpertiseGroup (ExpertiseGroupDto expertiseGroupDto);
}
