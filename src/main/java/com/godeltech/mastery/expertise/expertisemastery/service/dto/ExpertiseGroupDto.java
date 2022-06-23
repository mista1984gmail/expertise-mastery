package com.godeltech.mastery.expertise.expertisemastery.service.dto;

import com.godeltech.mastery.expertise.expertisemastery.persistence.entity.Expertise;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExpertiseGroupDto {

    @Null
    private Long id;

    @NotBlank
    private String name;

    private Set<Expertise> expertises;

    private boolean deleted;
}
