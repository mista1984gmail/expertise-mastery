package com.godeltech.mastery.expertise.expertisemastery.service;

import com.godeltech.mastery.expertise.expertisemastery.service.dto.ExpertiseDto;
import com.godeltech.mastery.expertise.expertisemastery.service.dto.ExpertiseGroupDto;

import java.util.List;

public interface ExpertiseGroupService {

    List<ExpertiseGroupDto> findAllExpertiseGroup();

    ExpertiseGroupDto saveNewExpertiseGroup(ExpertiseGroupDto expertiseGroupDto);

    ExpertiseGroupDto findById(Long id);

    void deleteExpertiseGroup (Long id);

    ExpertiseGroupDto updateExpertiseGroup(Long id, ExpertiseGroupDto expertiseGroupDto);

    List<ExpertiseDto> sortedExpertiseByNameASC(Long id);

    List<ExpertiseGroupDto> sortedExpertiseInGroup(String condition);
}
