package com.godeltech.mastery.expertise.expertisemastery.service;

import com.godeltech.mastery.expertise.expertisemastery.service.dto.ExpertiseDto;
import com.godeltech.mastery.expertise.expertisemastery.service.dto.ExpertiseGroupDto;
import com.godeltech.mastery.expertise.expertisemastery.service.sorting.SortingExpertises;

import java.util.List;

public interface SortingService {

    //List<ExpertiseDto> sortedExpertiseByNameASC(Long id);

    SortingExpertises sortedExpertiseInGroup(String condition);
}
