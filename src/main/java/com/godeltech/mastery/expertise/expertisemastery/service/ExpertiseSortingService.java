package com.godeltech.mastery.expertise.expertisemastery.service;

import com.godeltech.mastery.expertise.expertisemastery.service.sorting.ExpertiseSortType;
import com.godeltech.mastery.expertise.expertisemastery.web.dto.response.ExpertiseResponse;

import java.util.List;
import java.util.Map;

public interface ExpertiseSortingService {

    Map<String, List<ExpertiseResponse>> sortedExpertiseInGroup(ExpertiseSortType condition);
}
