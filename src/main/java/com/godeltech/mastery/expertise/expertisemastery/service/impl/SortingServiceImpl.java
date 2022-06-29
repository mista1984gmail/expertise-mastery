package com.godeltech.mastery.expertise.expertisemastery.service.impl;

import com.godeltech.mastery.expertise.expertisemastery.persistence.repository.ExpertiseGroupRepository;
import com.godeltech.mastery.expertise.expertisemastery.service.SortingService;
import com.godeltech.mastery.expertise.expertisemastery.service.dto.ExpertiseGroupDto;
import com.godeltech.mastery.expertise.expertisemastery.service.sorting.SortingExpertises;
import com.godeltech.mastery.expertise.expertisemastery.web.dto.response.ExpertiseResponse;
import com.godeltech.mastery.expertise.expertisemastery.web.mappers.ExpertiseGroupMapper;
import com.godeltech.mastery.expertise.expertisemastery.web.mappers.ExpertiseMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.godeltech.mastery.expertise.expertisemastery.service.sorting.SortingComparator.sortingExpertiseInGroups;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SortingServiceImpl implements SortingService {

    private final ExpertiseGroupRepository expertiseGroupRepository;
    private final ExpertiseGroupMapper expertiseGroupMapper;
    private final ExpertiseMapper expertiseMapper;

    @Override
    public SortingExpertises sortedExpertiseInGroup(String condition) {
        SortingExpertises sortingExpertises = new SortingExpertises();
        Map<String, List<ExpertiseResponse>> sortingExpertise = new HashMap<>();
        log.debug("Find all expertise groups");
        List<ExpertiseGroupDto> expertiseGroups = expertiseGroupMapper.toListDto(expertiseGroupRepository.findAll());
        for (ExpertiseGroupDto el:expertiseGroups) {
            sortingExpertise.put(el.getName(), expertiseMapper.toListResponse(expertiseMapper.toListDto(el.getExpertises())));
        }
        log.debug("Sorted expertise groups by condition: {}", condition);
        Map<String, List<ExpertiseResponse>> stringListMap = sortingExpertise.entrySet().stream()
                .peek(x->x.getValue().sort(sortingExpertiseInGroups(condition)))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,(e1,e2)->e1,HashMap::new));
        sortingExpertises.setSortingExpertise(sortingExpertise);

        return sortingExpertises;

    }
}

