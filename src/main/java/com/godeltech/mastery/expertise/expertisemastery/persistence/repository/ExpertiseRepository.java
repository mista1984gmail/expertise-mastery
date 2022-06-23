package com.godeltech.mastery.expertise.expertisemastery.persistence.repository;

import com.godeltech.mastery.expertise.expertisemastery.persistence.entity.Expertise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpertiseRepository extends JpaRepository<Expertise, Long> {
}
