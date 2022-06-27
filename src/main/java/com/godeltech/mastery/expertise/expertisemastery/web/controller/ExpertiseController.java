package com.godeltech.mastery.expertise.expertisemastery.web.controller;

import com.godeltech.mastery.expertise.expertisemastery.service.ExpertiseService;
import com.godeltech.mastery.expertise.expertisemastery.service.dto.ExpertiseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.QueryParam;
import java.util.List;

@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/expertise")
public class ExpertiseController {

    private final ExpertiseService expertiseService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ExpertiseDto create(@Valid @NotNull @RequestBody ExpertiseDto expertiseDto) {
        log.info("Save expertise " + expertiseDto);
        return expertiseService.saveNewExpertise(expertiseDto);
    }

    @GetMapping
    public ResponseEntity<List<ExpertiseDto>> getAll() {
        return ResponseEntity.ok(expertiseService.findAllExpertise());
    }

    @GetMapping("/{expertiseId}")
    @ResponseStatus(HttpStatus.OK)
    public ExpertiseDto getById(@NotNull @PathVariable Long expertiseId){
        log.info("Find expertise with id: " + expertiseId);
        return expertiseService.findById(expertiseId);
    }

    @DeleteMapping("/{expertiseId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@NotNull @PathVariable Long expertiseId) {
        log.info("Delete expertise with id: " + expertiseId);
        expertiseService.deleteExpertise(expertiseId);
    }

    @PutMapping("/{expertiseId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@NotNull @PathVariable("expertiseId") Long expertiseId, @Valid @NotNull @RequestBody ExpertiseDto expertiseDto){
        log.info("Update expertise with id: " + expertiseId);
        expertiseService.updateExpertise(expertiseId, expertiseDto);
    }

}
