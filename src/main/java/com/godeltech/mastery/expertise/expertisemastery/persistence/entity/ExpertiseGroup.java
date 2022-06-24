package com.godeltech.mastery.expertise.expertisemastery.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "expertise_group")
public class ExpertiseGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "deleted")
    private boolean deleted;

    @OneToMany(mappedBy = "expertiseGroup", cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JsonIgnore
    private Set<Expertise> expertise = new HashSet<>();

    public void setExpertise(final Set<Expertise> expertise) {
        this.expertise = expertise;

        for(Expertise e : expertise) {
            e.setExpertiseGroup(this);
        }
    }

}
