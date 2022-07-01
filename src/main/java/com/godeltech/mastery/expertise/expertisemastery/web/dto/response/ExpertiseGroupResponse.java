package com.godeltech.mastery.expertise.expertisemastery.web.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ExpertiseGroupResponse {

    private Long id;

    private String name;

    private List<ExpertiseResponse> expertises = new ArrayList<>();
}
