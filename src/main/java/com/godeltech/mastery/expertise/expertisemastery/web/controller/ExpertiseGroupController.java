package com.godeltech.mastery.expertise.expertisemastery.web.controller;

import com.godeltech.mastery.expertise.expertisemastery.service.ExpertiseGroupService;
import com.godeltech.mastery.expertise.expertisemastery.service.ExpertiseService;
import com.godeltech.mastery.expertise.expertisemastery.service.dto.ExpertiseDto;
import com.godeltech.mastery.expertise.expertisemastery.service.dto.ExpertiseGroupDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/expertise-group")
public class ExpertiseGroupController {

    private final ExpertiseGroupService expertiseGroupService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ExpertiseGroupDto> findAll() {
        log.info("Find all expertise");
        return expertiseGroupService.findAllExpertiseGroup();
    }

    @GetMapping("/{expertiseGroupId}")
    @ResponseStatus(HttpStatus.OK)
    public ExpertiseGroupDto getExpertiseGroupById(@NotNull @PathVariable Long expertiseGroupId){
        log.info("Find expertise group with id: " + expertiseGroupId);
        return expertiseGroupService.findById(expertiseGroupId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ExpertiseGroupDto saveNewExpertiseGroup(@Valid @NotNull @RequestBody ExpertiseGroupDto expertiseGroupDto){
        log.info("Save expertise " + expertiseGroupDto);
        return expertiseGroupService.saveNewExpertiseGroup(expertiseGroupDto);
    }

    @DeleteMapping("/{expertiseGroupId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@NotNull @PathVariable Long expertiseGroupId) {
        log.info("Delete expertise group with id: " + expertiseGroupId);
        expertiseGroupService.deleteExpertiseGroup(expertiseGroupId);
    }

    @PutMapping("/{expertiseGroupId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateExpertise(@NotNull @PathVariable("expertiseGroupId") Long expertiseGroupId, @Valid @NotNull @RequestBody ExpertiseGroupDto expertiseGroupDto){
        log.info("Update expertise group with id: " + expertiseGroupId);
        expertiseGroupService.updateExpertiseGroup(expertiseGroupId, expertiseGroupDto);
    }




}