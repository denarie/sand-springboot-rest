package de.denarie.sand.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import lombok.*;

import java.time.Instant;

/**
 * Country domain object.
 * The information about a country with names in different languages.
 * If a country does not exist anymore then it is still kept in the database and is a predecessor for the new country.
 *
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "t_laender")
public class Country {


    /**
     * the unique id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    private Integer id;

    /**
     * the country iso code
     */
    @Size(max = 4)
    @Column(name = "ISOCode", length = 4)
    private String iSOCode;

    /**
     * the german name for the country
     */
    @Size(max = 50)
    @Column(name = "Name_de", length = 50)
    private String nameDe;

    /**
     * the french name for the country
     */
    @Size(max = 50)
    @Column(name = "Name_fr", length = 50)
    private String nameFr;

    /**
     * the english name for the country
     */
    @Size(max = 50)
    @Column(name = "Name_en", length = 50)
    private String nameEn;

    /**
     * the capital city of the country
     */
    @Size(max = 50)
    @Column(name = "Hauptstadt", length = 50)
    private String capitalCity;

    /**
     * the year the country was established
     */
    @Column(name = "Gegruendet")
    private Integer established;

    /**
     * the year the country was closed
     */
    @Column(name = "Aufgeloest")
    private Integer closed;

    /**
     * the licence tag for the country
     */
    @Size(max = 3)
    @Column(name = "Autokennzeichen", length = 3)
    private String licenceTag;

    /**
     * the international abbreviation for this country
     */
    @Size(max = 3)
    @Column(name = "Abkuerzung_int", length = 3)
    private String abbreviationInternational;

    /**
     * true if the country no longer exists
     */
    @NotNull
    @Column(name = "historisch", nullable = false)
    private Boolean historycal = false;

    /**
     * if there exists a predecessor for this country then this is the unique id
     */
    @Column(name = "VorgaengerID")
    private Integer predecessorID;

    /**
     * date where this data was created
     */
    @Column(name = "Erstelldatum")
    private Instant creationDate;

    /**
     * date where this data was changed
     */
    @Column(name = "Aenderungsdatum")
    private Instant changeDate;

    /**
     * date where this data got the deleted status
     * This feature is not used.
     * TODO: get rid of it, the country table is read only and the historical data is saved.
     * A delete does not make sense.
     */
    @Column(name = "Loeschdatum")
    private Instant deletedDate;

    /**
     * Continents a country does belong to.
     * It is a many to many relationship because there exist countries that have territory on several continents, e.g. France with its territories Outre Mer.
     */
    @ManyToMany(fetch = FetchType.LAZY)
    // TODO not working @OrderBy("ID")
    @JoinTable(name = "t_b_laender_erdteile", //
            joinColumns = { @JoinColumn(name = "LandID", referencedColumnName = "ID") }, //
            inverseJoinColumns = { @JoinColumn(name = "ErdteilID", referencedColumnName = "ID") })
    private List<Continent> continents = new ArrayList<Continent>();

}