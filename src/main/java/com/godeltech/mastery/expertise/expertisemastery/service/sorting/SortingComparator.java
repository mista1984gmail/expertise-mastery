package com.godeltech.mastery.expertise.expertisemastery.service.sorting;

import com.godeltech.mastery.expertise.expertisemastery.exception.WrongSortingConditionException;
import com.godeltech.mastery.expertise.expertisemastery.web.dto.response.ExpertiseResponse;

import java.util.Comparator;

public class SortingComparator {
    private final static Comparator SORTING_EXPERTISE_BY_ID_ASC = Comparator.comparing(ExpertiseResponse::getId);
    private final static Comparator SORTING_EXPERTISE_BY_NAME_ASC = Comparator.comparing(ExpertiseResponse::getName);
    private final static Comparator SORTING_EXPERTISE_BY_NAME_DESC = Comparator.comparing(ExpertiseResponse::getName).reversed();

    private final static String SORTED_BY_ID_ASC= "sortedByIdASC";
    private final static String SORTED_BY_NAME_ASC= "sortedByNameASC";
    private final static String SORTED_BY_NAME_DESC= "sortedByNameDESC";



    public static Comparator sortingExpertiseInGroups(String condition){
        switch (condition){
            case SORTED_BY_ID_ASC:
                return SORTING_EXPERTISE_BY_ID_ASC;
            case SORTED_BY_NAME_ASC:
                return SORTING_EXPERTISE_BY_NAME_ASC;
            case  SORTED_BY_NAME_DESC:
                return SORTING_EXPERTISE_BY_NAME_DESC;
            default:
                throw new WrongSortingConditionException("Wrong condition for sorting expertise");
        }
}

}
