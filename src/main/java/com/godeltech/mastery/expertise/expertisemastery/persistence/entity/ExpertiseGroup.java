package com.godeltech.mastery.expertise.expertisemastery.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "expertise_group")
@SQLDelete(sql = "UPDATE expertise_group SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class ExpertiseGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "deleted")
    private boolean deleted;

    @OneToMany(mappedBy = "expertiseGroup", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JsonIgnore
    private List<Expertise> expertises = new ArrayList<>();

    public void setExpertises (List<Expertise> expertises) {
        this.expertises = expertises;
        for(Expertise e : expertises) {
            e.setExpertiseGroup(this);
        }
    }

}
