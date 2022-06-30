package com.godeltech.mastery.expertise.expertisemastery.service.impl;

import com.godeltech.mastery.expertise.expertisemastery.exception.EntityNotFoundException;
import com.godeltech.mastery.expertise.expertisemastery.persistence.entity.ExpertiseGroup;
import com.godeltech.mastery.expertise.expertisemastery.persistence.repository.ExpertiseGroupRepository;
import com.godeltech.mastery.expertise.expertisemastery.service.ExpertiseGroupService;
import com.godeltech.mastery.expertise.expertisemastery.service.dto.ExpertiseGroupDto;
import com.godeltech.mastery.expertise.expertisemastery.web.mappers.ExpertiseGroupMapper;
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
public class ExpertiseGroupServiceImpl implements ExpertiseGroupService {

    private final ExpertiseGroupRepository expertiseGroupRepository;
    private final ExpertiseGroupMapper expertiseGroupMapper;

    @Override
    public List<ExpertiseGroupDto> findAll() {
        log.debug("Find all expertise groups");
        return expertiseGroupMapper.toListDto(expertiseGroupRepository.findAll());
    }

    @Transactional
    @Override
    public ExpertiseGroupDto save(ExpertiseGroupDto expertiseGroupDto) {
        log.debug("Save expertise group with id: {}", expertiseGroupDto);
        return expertiseGroupMapper.expertiseGroupToExpertiseGroupDto(expertiseGroupRepository.save(expertiseGroupMapper.expertiseGroupDtoToExpertiseGroup(expertiseGroupDto)));
    }

    @Override
    public ExpertiseGroupDto findById(Long id) {
        log.debug("Find expertise group with id: {}", id);
        return Optional.of(getById(id)).get();
    }

    @Transactional
    @Override
    public void delete(Long id) {
        ExpertiseGroupDto expertiseGroupDto = getById(id);
        log.debug("Delete expertise group with id: {}", id);
        expertiseGroupRepository.delete(expertiseGroupMapper.expertiseGroupDtoToExpertiseGroup(expertiseGroupDto));
    }

    @Transactional
    @Override
    public ExpertiseGroupDto update(Long id, ExpertiseGroupDto expertiseGroupDto) {
        ExpertiseGroup expertiseGroupFromDb = expertiseGroupMapper.expertiseGroupDtoToExpertiseGroup(getById(id));
        expertiseGroupDto.setId(expertiseGroupFromDb.getId());
        log.debug("Update expertise: {}", expertiseGroupDto);
        return expertiseGroupMapper.expertiseGroupToExpertiseGroupDto(expertiseGroupRepository.save(expertiseGroupMapper.expertiseGroupDtoToExpertiseGroup(expertiseGroupDto)));
    }
    public ExpertiseGroupDto getById(Long id) {
        return expertiseGroupMapper.expertiseGroupToExpertiseGroupDto(expertiseGroupRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Expertise group with id: " + id + " not found")));
    }

}
