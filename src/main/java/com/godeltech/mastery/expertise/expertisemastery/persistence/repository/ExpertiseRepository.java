package com.godeltech.mastery.expertise.expertisemastery.persistence.repository;

import com.godeltech.mastery.expertise.expertisemastery.persistence.entity.Expertise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ExpertiseRepository extends JpaRepository<Expertise, Long> {

    @Modifying
    @Query("DELETE FROM Expertise e WHERE e.expertiseGroup.id = ?1")
    void deleteByExpertiseGroupId(Long expertiseGroupId);

    @Modifying
    @Query("UPDATE Expertise e SET e.deleted = true WHERE e.expertiseGroup.id = ?1")
    void softDeleteByExpertiseGroupId(Long expertiseGroupId);
}