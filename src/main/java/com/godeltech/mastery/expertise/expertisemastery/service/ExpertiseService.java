package com.godeltech.mastery.expertise.expertisemastery.service;

import com.godeltech.mastery.expertise.expertisemastery.service.dto.ExpertiseDto;

import java.util.List;

public interface ExpertiseService {

    List<ExpertiseDto> findAll();

    ExpertiseDto save(ExpertiseDto expertiseDto);

    ExpertiseDto findById(Long id);

    void delete(Long id);

    ExpertiseDto update(Long id, ExpertiseDto expertiseDto);

}
