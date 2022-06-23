package com.godeltech.mastery.expertise.expertisemastery.service;

import com.godeltech.mastery.expertise.expertisemastery.persistence.entity.Expertise;
import com.godeltech.mastery.expertise.expertisemastery.service.dto.ExpertiseDto;

import java.util.List;

public interface ExpertiseService {

    List<ExpertiseDto> findAllExpertise();

    ExpertiseDto saveNewExpertise(ExpertiseDto expertiseDto);

    ExpertiseDto findById(Long id);

    void deleteExpertise (Long id);

    ExpertiseDto updateExpertise(Long id, ExpertiseDto expertiseDto);



}
