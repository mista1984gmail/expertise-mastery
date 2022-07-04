package com.godeltech.mastery.expertise.expertisemastery.service.impl;

import com.godeltech.mastery.expertise.expertisemastery.persistence.entity.ExpertiseGroup;
import com.godeltech.mastery.expertise.expertisemastery.persistence.repository.ExpertiseGroupRepository;
import com.godeltech.mastery.expertise.expertisemastery.service.ExpertiseSortingService;
import com.godeltech.mastery.expertise.expertisemastery.service.sorting.ExpertiseSortType;
import com.godeltech.mastery.expertise.expertisemastery.web.dto.response.ExpertiseResponse;
import com.godeltech.mastery.expertise.expertisemastery.web.mappers.ExpertiseMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ExpertiseSortingServiceImpl implements ExpertiseSortingService {

    private final ExpertiseGroupRepository expertiseGroupRepository;
    private final ExpertiseMapper expertiseMapper;

    @Override
    public Map<String, List<ExpertiseResponse>> sortedExpertiseInGroup(ExpertiseSortType condition) {
        log.debug("Sorted expertise groups by condition: {}", condition);
        List<ExpertiseGroup> expertiseGroups = expertiseGroupRepository.findAll();

        Map<String, List<ExpertiseResponse>> sortedMap = new HashMap<>();
        for (ExpertiseGroup eg : expertiseGroups) {
            var sortList = eg.getExpertises().stream()
                    .sorted(condition.getComparator())
                    .collect(toList());
            sortedMap.put(eg.getName(), expertiseMapper.toListResponse(sortList));
        }

        return sortedMap;
    }

}

