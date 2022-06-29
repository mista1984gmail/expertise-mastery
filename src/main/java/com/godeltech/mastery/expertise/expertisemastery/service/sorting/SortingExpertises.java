package com.godeltech.mastery.expertise.expertisemastery.service.sorting;

import com.godeltech.mastery.expertise.expertisemastery.service.dto.ExpertiseDto;
import com.godeltech.mastery.expertise.expertisemastery.web.dto.response.ExpertiseResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class SortingExpertises {

    Map<String, List<ExpertiseResponse>> sortingExpertise = new HashMap<>();;
}
