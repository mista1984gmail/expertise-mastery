package com.godeltech.mastery.expertise.expertisemastery.persistence.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "expertise")
@SQLDelete(sql = "UPDATE expertise SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class Expertise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="expertise_group_id")
    @Fetch(FetchMode.JOIN)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private ExpertiseGroup expertiseGroup;


    @Column(name = "deleted")
    private boolean deleted;

}

