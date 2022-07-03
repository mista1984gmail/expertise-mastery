package com.godeltech.mastery.expertise.expertisemastery.service.sorting;

import com.godeltech.mastery.expertise.expertisemastery.persistence.entity.Expertise;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Comparator;
@Getter
@AllArgsConstructor
public enum ExpertiseSortType {
    BY_ID_ASC(Comparator.comparing(Expertise::getId)),
    BY_ID_DESC(BY_ID_ASC.getComparator().reversed()),
    BY_NAME_ASC(Comparator.comparing(Expertise::getName)),
    BY_NAME_DESC(BY_NAME_ASC.getComparator().reversed());

    private final Comparator <Expertise> comparator;

}
