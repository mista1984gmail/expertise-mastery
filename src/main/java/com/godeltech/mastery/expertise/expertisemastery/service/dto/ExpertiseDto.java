package com.godeltech.mastery.expertise.expertisemastery.service.dto;

import com.godeltech.mastery.expertise.expertisemastery.persistence.entity.ExpertiseGroup;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExpertiseDto {

    @Null
    private Long id;

    @NotBlank
    private String name;

    private ExpertiseGroup expertiseGroup;

    private boolean deleted;
}
