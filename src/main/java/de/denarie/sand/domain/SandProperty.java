package de.denarie.sand.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

/**
 * Configuration domain object.
 * This object is used to store configuration for the application.
 *
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "t_einstellungen")
public class SandProperty {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Size(max = 50)
    @NotNull
    @Column(name = "ParamName", nullable = false, length = 50)
    private String paramName;

    @Size(max = 50)
    @NotNull
    @Column(name = "ParamWert", nullable = false, length = 50)
    private String paramValue;

}