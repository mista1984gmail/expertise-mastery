package com.godeltech.mastery.expertise.expertisemastery.service.impl;

import com.godeltech.mastery.expertise.expertisemastery.exception.ConditionForSortedNotFoundException;
import com.godeltech.mastery.expertise.expertisemastery.exception.EntityNotFoundException;
import com.godeltech.mastery.expertise.expertisemastery.persistence.entity.Expertise;
import com.godeltech.mastery.expertise.expertisemastery.persistence.entity.ExpertiseGroup;
import com.godeltech.mastery.expertise.expertisemastery.persistence.repository.ExpertiseGroupRepository;
import com.godeltech.mastery.expertise.expertisemastery.persistence.repository.ExpertiseRepository;
import com.godeltech.mastery.expertise.expertisemastery.service.SortingService;
import com.godeltech.mastery.expertise.expertisemastery.service.dto.ExpertiseDto;
import com.godeltech.mastery.expertise.expertisemastery.service.dto.ExpertiseGroupDto;
import com.godeltech.mastery.expertise.expertisemastery.service.sorting.SortingExpertises;
import com.godeltech.mastery.expertise.expertisemastery.web.dto.response.ExpertiseResponse;
import com.godeltech.mastery.expertise.expertisemastery.web.mappers.ExpertiseGroupMapper;
import com.godeltech.mastery.expertise.expertisemastery.web.mappers.ExpertiseMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SortingServiceImpl implements SortingService {

    private final ExpertiseGroupRepository expertiseGroupRepository;
    private final ExpertiseRepository expertiseRepository;
    private final ExpertiseGroupMapper expertiseGroupMapper;
    private final ExpertiseMapper expertiseMapper;

/*    @Override
    public List<ExpertiseDto> sortedExpertiseByNameASC(Long id) {
        ExpertiseGroup expertiseGroupFromDb = expertiseGroupMapper.expertiseGroupDtoToExpertiseGroup(getById(id));
        return expertiseMapper.toListDto(expertiseGroupFromDb.getExpertises().stream().sorted(Comparator.comparing(Expertise::getName)).toList());
    }*/

    @Override
    public SortingExpertises sortedExpertiseInGroup(String condition) {
        SortingExpertises sortingExpertises = new SortingExpertises();
        Map<String, List<ExpertiseResponse>> sortingExpertise = new HashMap<>();
        List<ExpertiseGroupDto> expertiseGroups = expertiseGroupMapper.toListDto(expertiseGroupRepository.findAll());
        for (ExpertiseGroupDto el:expertiseGroups) {
            sortingExpertise.put(el.getName(), expertiseMapper.toListResponse(expertiseMapper.toListDto(el.getExpertises())));
        }
//        sortingExpertise.entrySet()
//                        .stream()
//                                .sorted(Map.Entry.<String,List<ExpertiseResponse>>comparingByValue())
//                                        .collect((Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new))
        sortingExpertises.setSortingExpertise(sortingExpertise);

        return sortingExpertises;
 /*       log.debug("Find all expertise groups");

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
        return expertiseGroups;*/
    }
}

