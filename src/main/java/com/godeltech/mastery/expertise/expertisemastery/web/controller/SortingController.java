package com.godeltech.mastery.expertise.expertisemastery.web.controller;

import com.godeltech.mastery.expertise.expertisemastery.service.SortingService;
import com.godeltech.mastery.expertise.expertisemastery.service.sorting.SortingExpertises;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/sorting-expertise-groups")
public class SortingController {

    private final SortingService sortingService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public SortingExpertises sortedExpertiseInGroup(@RequestParam ("condition") @NotNull String condition) {
        log.info("Sorted expertise in expertise group");
        return sortingService.sortedExpertiseInGroup(condition);
    }


}
