package de.denarie.sand.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Continent domain object.
 *
 */
@EqualsAndHashCode(exclude = {"countries"})
@ToString(exclude = {"countries"})
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "t_erdteile")
public class Continent {
    /**
     * the unique id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    private Integer id;

    /**
     * the name of the continent
     * TODO internationalization
     */
    @Size(max = 50)
    @NotNull
    @Column(name = "Name", nullable = false, length = 50)
    private String name;


    /**
     * The list of countries that belong to this continent
     */
    @Builder.Default
    @ManyToMany(mappedBy = "continents", fetch = FetchType.LAZY)
    private final Set<Country> countries = new HashSet<Country>();

//    public void addCountry(Country country) {
//        this.getCountries().add(country);
//        if (!country.getContinents().contains(this)) {
//            country.getContinents().add(this);
//        }
//    }

}