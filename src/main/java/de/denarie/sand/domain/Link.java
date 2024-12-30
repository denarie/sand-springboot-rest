package de.denarie.sand.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


/**
 * Link domain object.
 * A link belongs to one sand item and contains additional information to a collected sand item, such as
 * <ul>
 * 		<li>A web url with a link to a specific site with more information about the area the sand was collected</li>
 * 		<li>A relative path to a picture or movie from the place where the sand was collected, or from the collection ievent itself</li>
 * </ul>
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "t_links", indexes = {
        @Index(name = "SandID", columnList = "SandID")
})
public class Link {
    /**
     * the unique id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    private Integer id;

    /**
     * the sand item to which the link object belongs
     */
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "SandID", nullable = false)
    private Sand sand;

    /**
     * The url of the link, could be a web address or a local relative path
     */
    @Size(max = 200)
    @NotNull
    @Column(name = "URL", nullable = false, length = 200)
    private String url;

    @Size(max = 5)
    @Column(name = "typ", length = 5)
    private String type;


    /**
     * remark for the link
     */
    @Size(max = 50)
    @Column(name = "Bemerkung", length = 50)
    private String remark;

}