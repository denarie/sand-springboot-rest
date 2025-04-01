package de.denarie.sand.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

/**
 * Person domain object. A person is someone who collected a sand item.
 *
 */
@EqualsAndHashCode(exclude = {"sands"})
@ToString(exclude = {"sands"})
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
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

    @Builder.Default
    @ManyToMany(mappedBy = "persons", fetch = FetchType.LAZY)
    private Set<Sand> sands = new HashSet<Sand>();

//    @PreRemove
//    private void removePersonCheck() throws PersonDeleteRestrictException {
//        if (!this.getSands().isEmpty()) {
//            throw new PersonDeleteRestrictException(this.id);
//        }
//    }
}