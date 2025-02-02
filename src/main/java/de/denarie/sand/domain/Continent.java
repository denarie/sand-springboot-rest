package de.denarie.sand.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Continent domain object.
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
     * the german name of the continent
     * TODO add more languages
     */
    @Size(max = 50)
    @NotNull
    @Column(name = "Name", nullable = false, length = 50)
    private String name;


    /**
     * The list of countries that belong to this continent
     */
    @ManyToMany(mappedBy = "continents", fetch = FetchType.LAZY)
    private final List<Country> countries = new ArrayList<Country>();

//    public void addCountry(Country country) {
//        this.getCountries().add(country);
//        if (!country.getContinents().contains(this)) {
//            country.getContinents().add(this);
//        }
//    }
}