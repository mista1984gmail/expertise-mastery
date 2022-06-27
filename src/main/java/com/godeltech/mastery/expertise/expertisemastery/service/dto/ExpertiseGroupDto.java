package com.godeltech.mastery.expertise.expertisemastery.service.dto;

import com.godeltech.mastery.expertise.expertisemastery.persistence.entity.Expertise;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExpertiseGroupDto {

    @Null
    private Long id;

    @NotBlank
    private String name;

    private boolean deleted;

    private List<Expertise> expertise = new ArrayList<>();
}
