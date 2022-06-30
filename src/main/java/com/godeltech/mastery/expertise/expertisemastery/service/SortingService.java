package com.godeltech.mastery.expertise.expertisemastery.service;

import com.godeltech.mastery.expertise.expertisemastery.service.sorting.SortingExpertises;

public interface SortingService {

    SortingExpertises sortedExpertiseInGroup(String condition);
}
