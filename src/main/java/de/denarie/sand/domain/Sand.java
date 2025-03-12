package de.denarie.sand.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * The sand domain object.
 * Represents an item in the sand collection.
 *
 */
@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "t_sand")
public class Sand {

    /**
     * the unique id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", updatable = false, nullable = false)
    private Long id;

    /**
     * the short name of the sand
     */
    @Column(name = "Kurzname", length = 50, nullable = false, unique = false)
    @NotNull
    @Size(max=50)
    private String name;

    /**
     * the long name of the sand
     */
    @Column(name = "Langname", length = 100, nullable = false, unique = false)
    @NotNull
    @Size(max=100)
    private String longname;

    /**
     * the year when the sand was collected, optional
     */
    @Column(name = "Jahr", nullable = true, unique = false)
    private Integer year;

    /**
     * the month when the sand was collected, optional
     */
    @ManyToOne(optional = true, fetch=FetchType.EAGER, cascade = {CascadeType.REFRESH})
    @JoinColumn(name="Monat", unique = false, nullable = true)
    private Month month;

    /**
     * the day when the sand was collected, optional
     */
    @Column(name = "Tag", nullable = true, unique = false)
    private Integer day;

    /**
     * the longitude where the sand was collected, optional
     */
    @Column(name = "KoordLaenge", nullable = true, unique = false)
    @DecimalMin(value = "-180.00")
    @DecimalMax(value = "180.00")
    private BigDecimal longitude;

    /**
     * the latitude where the sand was collected, optional
     */
    @Column(name = "KoordBreite", nullable = true, unique = false)
    @DecimalMin(value = "-90.00")
    @DecimalMax(value = "90.00")
    private BigDecimal latitude;

    /**
     * the country where the sand was collected, optional
     */
    @ManyToOne(optional = true, fetch=FetchType.EAGER, cascade = {CascadeType.REFRESH})
    @JoinColumn(name="LandID", unique = false, nullable = true)
    private Country country;

    /**
     * history information about the collecting event, optional
     */
    @Column(name = "Geschichte", length = 255, nullable = true, unique = false)
    @Size(max=255)
    private String history;

    /**
     * remark about the collecting event, optional
     */
    @Column(name = "Bemerkung", length = 255, nullable = true, unique = false)
    @Size(max=255)
    private String remark;

    /**
     * The persons who collected this sand item
     */
    @Builder.Default
    @ManyToMany(fetch=FetchType.LAZY,  cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "t_b_sand_leute", //
            joinColumns = { @JoinColumn(name = "SandID", referencedColumnName = "ID") }, //
            inverseJoinColumns = { @JoinColumn(name = "LeutID", referencedColumnName = "ID") })
    private Set<Person> persons = new HashSet<Person>();

    /**
     * The links for this sand item
     */
    @OneToMany(mappedBy="sand", fetch=FetchType.LAZY, cascade = {CascadeType.ALL})
    private Set<Link> links = new HashSet<>();

    public void addPerson(Person person) {
        this.persons.add(person);
        person.getSands().add(this);
    }

    public void removePerson(Person person) {
        this.persons.remove(person);
        person.getSands().remove(this);
    }

//  @Version
//  private long version = 0; TODO Add version to handle concurrent modification
//

    // TODO
//    /**
//     * Before a sand is deleted, the sand item has to be deleted from the persons list of sands.
//     */
//    @PreRemove
//    private void removePersonsFromSand() {
//        for (Person p : persons) {
//            p.getSands().remove(this);
//        }
//    }

}
