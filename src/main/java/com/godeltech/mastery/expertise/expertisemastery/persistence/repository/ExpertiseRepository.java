package com.godeltech.mastery.expertise.expertisemastery.persistence.repository;

import com.godeltech.mastery.expertise.expertisemastery.persistence.entity.Expertise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface ExpertiseRepository extends JpaRepository<Expertise, Long> {

    @Modifying
    @Transactional
    @Query("DELETE FROM Expertise e WHERE e.expertiseGroup.id = ?1")
    void deleteByExpertiseGroupId(Long expertiseGroupId);
}
