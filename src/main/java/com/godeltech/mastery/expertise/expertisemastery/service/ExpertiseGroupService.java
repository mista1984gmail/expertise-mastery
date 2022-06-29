package com.godeltech.mastery.expertise.expertisemastery.service;

import com.godeltech.mastery.expertise.expertisemastery.service.dto.ExpertiseDto;
import com.godeltech.mastery.expertise.expertisemastery.service.dto.ExpertiseGroupDto;

import java.util.List;

public interface ExpertiseGroupService {

    List<ExpertiseGroupDto> findAll();

    ExpertiseGroupDto save(ExpertiseGroupDto expertiseGroupDto);

    ExpertiseGroupDto findById(Long id);

    void delete(Long id);

    ExpertiseGroupDto update(Long id, ExpertiseGroupDto expertiseGroupDto);

}
