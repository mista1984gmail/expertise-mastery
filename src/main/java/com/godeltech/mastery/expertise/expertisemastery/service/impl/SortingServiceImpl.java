package com.godeltech.mastery.expertise.expertisemastery.service.impl;

import com.godeltech.mastery.expertise.expertisemastery.persistence.repository.ExpertiseGroupRepository;
import com.godeltech.mastery.expertise.expertisemastery.service.SortingService;
import com.godeltech.mastery.expertise.expertisemastery.service.sorting.ConditionForSortingExpertise;
import com.godeltech.mastery.expertise.expertisemastery.web.dto.response.ExpertiseGroupResponse;
import com.godeltech.mastery.expertise.expertisemastery.web.dto.response.ExpertiseResponse;
import com.godeltech.mastery.expertise.expertisemastery.web.mappers.ExpertiseGroupMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SortingServiceImpl implements SortingService {

    private final ExpertiseGroupRepository expertiseGroupRepository;
    private final ExpertiseGroupMapper expertiseGroupMapper;

    @Override
    public Map<String, List<ExpertiseResponse>> sortedExpertiseInGroup(ConditionForSortingExpertise condition) {
        log.debug("Sorted expertise groups by condition: {}", condition);
        return init().entrySet().stream()
                .peek(x->x.getValue().sort(condition.getComparator()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,(e1,e2)->e1,HashMap::new));
    }

    public Map<String, List<ExpertiseResponse>> init(){
        log.debug("Find all expertise groups");
        List<ExpertiseGroupResponse> expertiseGroups = expertiseGroupMapper.toListResponse(expertiseGroupMapper.toListDto(expertiseGroupRepository.findAll()));
        return expertiseGroups.stream()
                .collect(toMap(ExpertiseGroupResponse::getName, ExpertiseGroupResponse::getExpertises));
    }

}

