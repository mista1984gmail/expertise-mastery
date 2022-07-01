package com.godeltech.mastery.expertise.expertisemastery.service;

import com.godeltech.mastery.expertise.expertisemastery.service.sorting.ConditionForSortingExpertise;
import com.godeltech.mastery.expertise.expertisemastery.web.dto.response.ExpertiseResponse;

import java.util.List;
import java.util.Map;

public interface SortingService {

    Map<String, List<ExpertiseResponse>> sortedExpertiseInGroup(ConditionForSortingExpertise condition);
}
