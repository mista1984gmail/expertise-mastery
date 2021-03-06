package com.godeltech.mastery.expertise.expertisemastery.web.mappers;

import com.godeltech.mastery.expertise.expertisemastery.persistence.entity.Expertise;
import com.godeltech.mastery.expertise.expertisemastery.service.dto.ExpertiseDto;
import com.godeltech.mastery.expertise.expertisemastery.web.dto.response.ExpertiseResponse;
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
    @Mapping(source = "expertiseDto.name", target = "name")
    @Mapping(source = "expertiseDto.id", target = "id")
    ExpertiseResponse dtoToResponse(ExpertiseDto expertiseDto);

    List<ExpertiseResponse> dtoListToListResponse(
            List<ExpertiseDto> expertiseDtos);

    List<ExpertiseResponse> toListResponse(
            List<Expertise> expertises);

}
