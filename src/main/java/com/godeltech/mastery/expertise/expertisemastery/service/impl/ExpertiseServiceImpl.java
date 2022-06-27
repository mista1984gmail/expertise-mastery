package com.godeltech.mastery.expertise.expertisemastery.service.impl;


import com.godeltech.mastery.expertise.expertisemastery.exception.EntityNotFoundException;
import com.godeltech.mastery.expertise.expertisemastery.persistence.entity.Expertise;
import com.godeltech.mastery.expertise.expertisemastery.persistence.entity.ExpertiseGroup;
import com.godeltech.mastery.expertise.expertisemastery.persistence.repository.ExpertiseRepository;
import com.godeltech.mastery.expertise.expertisemastery.service.ExpertiseGroupService;
import com.godeltech.mastery.expertise.expertisemastery.service.ExpertiseService;
import com.godeltech.mastery.expertise.expertisemastery.service.dto.ExpertiseDto;
import com.godeltech.mastery.expertise.expertisemastery.service.dto.ExpertiseGroupDto;
import com.godeltech.mastery.expertise.expertisemastery.web.mappers.ExpertiseGroupMapper;
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
    private final ExpertiseGroupService expertiseGroupService;

    private final ExpertiseGroupMapper expertiseGroupMapper;
    private final ExpertiseMapper expertiseMapper;

    @Override
    public List<ExpertiseDto> findAllExpertise() {
        log.debug("Find all expertises");
        return expertiseMapper.toListDto(expertiseRepository.findAll());
    }
    @Transactional
    @Override
    public ExpertiseDto saveNewExpertise(ExpertiseDto expertiseDto) {

        ExpertiseGroupDto optionalExpertiseGroup= expertiseGroupService.findById(expertiseDto.getExpertiseGroup().getId());
        expertiseDto.setExpertiseGroup(expertiseGroupMapper.expertiseGroupDtoToExpertiseGroup(optionalExpertiseGroup));
        Expertise savedExpertise = expertiseRepository.save(expertiseMapper.expertiseDtoToExpertise(expertiseDto));

        log.debug("Save expertise: {}", expertiseDto);
        return expertiseMapper.expertiseToExpertiseDto(savedExpertise);
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
        ExpertiseGroup expertiseGroupFromDb = expertiseGroupMapper.expertiseGroupDtoToExpertiseGroup(expertiseGroupService.findById(expertiseDto.getExpertiseGroup().getId()));
        Expertise expertiseFromDb = expertiseMapper.expertiseDtoToExpertise(getById(id));
        expertiseDto.setExpertiseGroup(expertiseGroupFromDb);
        expertiseDto.setId(expertiseFromDb.getId());
        log.debug("Update expertise: {}", expertiseDto);
        return expertiseMapper.expertiseToExpertiseDto(expertiseRepository.save(expertiseMapper.expertiseDtoToExpertise(expertiseDto)));
    }

    public ExpertiseDto getById(Long id) {
        return expertiseMapper.expertiseToExpertiseDto(expertiseRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Expertise with id: " + id + " not found")));
    }
}
