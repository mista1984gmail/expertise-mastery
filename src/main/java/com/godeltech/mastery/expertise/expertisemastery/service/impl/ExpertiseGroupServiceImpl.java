package com.godeltech.mastery.expertise.expertisemastery.service.impl;

import com.godeltech.mastery.expertise.expertisemastery.exception.ConditionForSortedNotFoundException;
import com.godeltech.mastery.expertise.expertisemastery.exception.EntityNotFoundException;
import com.godeltech.mastery.expertise.expertisemastery.persistence.entity.Expertise;
import com.godeltech.mastery.expertise.expertisemastery.persistence.entity.ExpertiseGroup;
import com.godeltech.mastery.expertise.expertisemastery.persistence.repository.ExpertiseGroupRepository;
import com.godeltech.mastery.expertise.expertisemastery.persistence.repository.ExpertiseRepository;
import com.godeltech.mastery.expertise.expertisemastery.service.ExpertiseGroupService;
import com.godeltech.mastery.expertise.expertisemastery.service.dto.ExpertiseDto;
import com.godeltech.mastery.expertise.expertisemastery.service.dto.ExpertiseGroupDto;
import com.godeltech.mastery.expertise.expertisemastery.web.mappers.ExpertiseGroupMapper;
import com.godeltech.mastery.expertise.expertisemastery.web.mappers.ExpertiseMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.function.Consumer;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ExpertiseGroupServiceImpl implements ExpertiseGroupService {

    private final ExpertiseGroupRepository expertiseGroupRepository;
    private final ExpertiseRepository expertiseRepository;
    private final ExpertiseGroupMapper expertiseGroupMapper;
    private final ExpertiseMapper expertiseMapper;


    @Override
    public List<ExpertiseGroupDto> findAllExpertiseGroup() {
        log.debug("Find all expertise groups");
        return expertiseGroupMapper.toListDto(expertiseGroupRepository.findAll());
    }

    @Transactional
    @Override
    public ExpertiseGroupDto saveNewExpertiseGroup(ExpertiseGroupDto expertiseGroupDto) {
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
    public void deleteExpertiseGroup(Long id) {
        ExpertiseGroupDto expertiseGroupDto = getById(id);
        log.debug("Delete expertise group with id: {}", id);
        expertiseRepository.deleteByExpertiseGroupId(id);
        expertiseGroupRepository.delete(expertiseGroupMapper.expertiseGroupDtoToExpertiseGroup(expertiseGroupDto));

    }

    @Transactional
    @Override
    public ExpertiseGroupDto updateExpertiseGroup(Long id, ExpertiseGroupDto expertiseGroupDto) {
        ExpertiseGroup expertiseGroupFromDb = expertiseGroupMapper.expertiseGroupDtoToExpertiseGroup(getById(id));
        expertiseGroupDto.setId(expertiseGroupFromDb.getId());
        log.debug("Update expertise: {}", expertiseGroupDto);
        return expertiseGroupMapper.expertiseGroupToExpertiseGroupDto(expertiseGroupRepository.save(expertiseGroupMapper.expertiseGroupDtoToExpertiseGroup(expertiseGroupDto)));
    }

    @Override
    public List<ExpertiseDto> sortedExpertiseByNameASC(Long id) {
        ExpertiseGroup expertiseGroupFromDb = expertiseGroupMapper.expertiseGroupDtoToExpertiseGroup(getById(id));
        return expertiseMapper.toListDto(expertiseGroupFromDb.getExpertises().stream().sorted(Comparator.comparing(Expertise::getName)).toList());
    }

    @Override
    public List<ExpertiseGroupDto> sortedExpertiseInGroup(String condition) {
        log.debug("Find all expertise groups");

        List<ExpertiseGroupDto> expertiseGroups = expertiseGroupMapper.toListDto(expertiseGroupRepository.findAll());
        Map<String, Consumer<List<ExpertiseGroupDto>>> consumerMap = new HashMap<>();
        consumerMap.put("sortedByNameASC", expertiseGroupDtoList -> {
            expertiseGroupDtoList.forEach(expertiseGroupDto -> expertiseGroupDto.getExpertises().sort(Comparator.comparing(Expertise::getName)));
        });
        consumerMap.put("sortedByIdASC", expertiseGroupDtoList -> {
            expertiseGroupDtoList.forEach(expertiseGroupDto -> expertiseGroupDto.getExpertises().sort(Comparator.comparing(Expertise::getId)));
        });
        consumerMap.put("sortedByNameDESC", expertiseGroupDtoList -> {
            expertiseGroupDtoList.forEach(expertiseGroupDto -> expertiseGroupDto.getExpertises().sort(Comparator.comparing(Expertise::getName).reversed()));
        });
        if (consumerMap.get(condition) != null) {
            consumerMap.get(condition).accept(expertiseGroups);
        } else throw new ConditionForSortedNotFoundException("Condition for sorted  expertise not found ");
        return expertiseGroups;
    }

    public ExpertiseGroupDto getById(Long id) {
        return expertiseGroupMapper.expertiseGroupToExpertiseGroupDto(expertiseGroupRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Expertise group with id: " + id + " not found")));
    }

}
