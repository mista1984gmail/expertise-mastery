package com.godeltech.mastery.expertise.expertisemastery.service.impl;

import com.godeltech.mastery.expertise.expertisemastery.exception.EntityNotFoundException;
import com.godeltech.mastery.expertise.expertisemastery.persistence.entity.Expertise;
import com.godeltech.mastery.expertise.expertisemastery.persistence.repository.ExpertiseRepository;
import com.godeltech.mastery.expertise.expertisemastery.service.ExpertiseService;
import com.godeltech.mastery.expertise.expertisemastery.service.dto.ExpertiseDto;
import com.godeltech.mastery.expertise.expertisemastery.web.mappers.ExpertiseMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ExpertiseServiceImpl implements ExpertiseService {

    private final ExpertiseRepository expertiseRepository;

    private final ExpertiseMapper expertiseMapper;


    @Override
    public List<ExpertiseDto> findAllExpertise() {
        log.debug("Find all expertises");
        return expertiseMapper.toListDto(expertiseRepository.findAll());
    }
    @Transactional
    @Override
    public ExpertiseDto saveNewExpertise(ExpertiseDto expertiseDto) {
        log.debug("Save expertise with id: {}", expertiseDto);
        return expertiseMapper.expertiseToExpertiseDto(expertiseRepository.save(expertiseMapper.expertiseDtoToExpertise(expertiseDto)));
    }

    @Override
    public ExpertiseDto findById(Long id) {
        log.debug("Find expertise with id: {}", id);
        return Optional.of(getById(id)).get();
    }

    @Override
    @Transactional
    public void deleteExpertise(Long id) {
        ExpertiseDto expertiseDto = getById(id);
        log.debug("Delete expertise with id: {}", id);
        expertiseRepository.delete(expertiseMapper.expertiseDtoToExpertise(expertiseDto));
    }

    @Override
    @Transactional
    public ExpertiseDto updateExpertise(Long id,ExpertiseDto expertiseDto) {
        Expertise expertiseFromDb = expertiseMapper.expertiseDtoToExpertise(getById(id));
        expertiseMapper.updateEntityToModel(expertiseFromDb, expertiseDto);
        log.debug("Update expertise: {}", expertiseDto);
        return expertiseMapper.expertiseToExpertiseDto(expertiseRepository.save(expertiseFromDb));
    }

    public ExpertiseDto getById(Long id) {
        return expertiseMapper.expertiseToExpertiseDto(expertiseRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Expertise with id: " + id + " not found")));
    }
}
