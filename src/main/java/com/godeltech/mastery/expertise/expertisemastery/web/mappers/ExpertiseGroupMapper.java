package com.godeltech.mastery.expertise.expertisemastery.web.mappers;

import com.godeltech.mastery.expertise.expertisemastery.persistence.entity.ExpertiseGroup;
import com.godeltech.mastery.expertise.expertisemastery.service.dto.ExpertiseGroupDto;
import com.godeltech.mastery.expertise.expertisemastery.web.dto.response.ExpertiseGroupResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper
public interface ExpertiseGroupMapper {

    ExpertiseGroupDto expertiseGroupToExpertiseGroupDto (ExpertiseGroup expertiseGroup);

    ExpertiseGroup expertiseGroupDtoToExpertiseGroup (ExpertiseGroupDto expertiseGroupDto);

    List<ExpertiseGroupDto> toListDto(List<ExpertiseGroup> expertiseGroups);

    @Mapping(target = "id", ignore = true)
    void updateEntityToModel(@MappingTarget ExpertiseGroup target, ExpertiseGroupDto source);

    @Mapping(source = "expertiseGroupDto.name", target = "name")
    @Mapping(source = "expertiseGroupDto.id", target = "id")
    @Mapping(source = "expertiseGroupDto.expertises", target = "expertises")
    ExpertiseGroupResponse dtoToResponse(ExpertiseGroupDto expertiseGroupDto);

    List<ExpertiseGroupResponse> toListResponse(
            List<ExpertiseGroupDto> ExpertiseGroupDtos);

}
