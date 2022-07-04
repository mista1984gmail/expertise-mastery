package com.godeltech.mastery.expertise.expertisemastery.web.controller;

import com.godeltech.mastery.expertise.expertisemastery.service.ExpertiseSortingService;
import com.godeltech.mastery.expertise.expertisemastery.service.sorting.ExpertiseSortType;
import com.godeltech.mastery.expertise.expertisemastery.web.dto.response.ExpertiseResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/sorting-expertise-groups")
public class SortingController {

    private final ExpertiseSortingService sortingService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Map<String, List<ExpertiseResponse>> sortedExpertiseInGroup(@RequestParam ("condition") @NotNull ExpertiseSortType condition) {
        log.info("Sorted expertise in expertise group");
        return sortingService.sortedExpertiseInGroup(condition);
    }


}
