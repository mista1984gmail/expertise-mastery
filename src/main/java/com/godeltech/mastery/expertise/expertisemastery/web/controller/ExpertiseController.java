package com.godeltech.mastery.expertise.expertisemastery.web.controller;

import com.godeltech.mastery.expertise.expertisemastery.service.ExpertiseService;
import com.godeltech.mastery.expertise.expertisemastery.service.dto.ExpertiseDto;
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
@RequestMapping("api/v1/expertise")
public class ExpertiseController {

    private final ExpertiseService expertiseService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ExpertiseDto> findAll() {
        log.info("Find all expertise");
        return expertiseService.findAllExpertise();
    }

    @GetMapping("/{expertiseId}")
    @ResponseStatus(HttpStatus.OK)
    public ExpertiseDto getExpertiseById(@NotNull @PathVariable Long expertiseId){
        log.info("Find expertise with id: " + expertiseId);
        return expertiseService.findById(expertiseId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ExpertiseDto saveNewExpertise(@Valid @NotNull @RequestBody ExpertiseDto expertiseDto){
        log.info("Save expertise " + expertiseDto);
        return expertiseService.saveNewExpertise(expertiseDto);
    }

    @DeleteMapping("/{expertiseId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@NotNull @PathVariable Long expertiseId) {
        log.info("Delete expertise with id: " + expertiseId);
        expertiseService.deleteExpertise(expertiseId);
    }

    @PutMapping("/{expertiseId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateExpertise(@NotNull @PathVariable("expertiseId") Long expertiseId, @Valid @NotNull @RequestBody ExpertiseDto expertiseDto){
        log.info("Update expertise with id: " + expertiseId);
        expertiseService.updateExpertise(expertiseId, expertiseDto);
    }




}
