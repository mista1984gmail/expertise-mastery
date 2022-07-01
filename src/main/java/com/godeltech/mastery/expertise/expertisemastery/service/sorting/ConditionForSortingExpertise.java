package com.godeltech.mastery.expertise.expertisemastery.service.sorting;

import com.godeltech.mastery.expertise.expertisemastery.web.dto.response.ExpertiseResponse;

import java.util.Comparator;

public enum ConditionForSortingExpertise {
    SORTING_EXPERTISE_BY_ID_ASC(Comparator.comparing(ExpertiseResponse::getId)),
    SORTING_EXPERTISE_BY_ID_DESC(Comparator.comparing(ExpertiseResponse::getId).reversed()),
    SORTING_EXPERTISE_BY_NAME_ASC(Comparator.comparing(ExpertiseResponse::getName)),
    SORTING_EXPERTISE_BY_NAME_DESC(Comparator.comparing(ExpertiseResponse::getName).reversed());

    private Comparator comparator;

    ConditionForSortingExpertise(Comparator comparator) {
        this.comparator = comparator;
    }

    public Comparator getComparator() {
        return comparator;
    }
}
