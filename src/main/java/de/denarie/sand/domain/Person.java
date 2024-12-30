package de.denarie.sand.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Person domain object. A person is someone who collected a sand item.
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "t_leute")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID",  updatable = false, nullable = false)
    private Integer id;

    @Size(max = 50)
    @NotNull
    @Column(name = "Name", nullable = false, length = 50)
    private String name;

    @Lob
    @Column(name = "Bemerkung")
    private String remark;

    @ManyToMany(mappedBy = "persons", fetch = FetchType.LAZY)
    private List<Sand> sands = new ArrayList<Sand>();

//    @PreRemove
//    private void removePersonCheck() throws PersonDeleteRestrictException {
//        if (!this.getSands().isEmpty()) {
//            throw new PersonDeleteRestrictException(this.id);
//        }
//    }
}