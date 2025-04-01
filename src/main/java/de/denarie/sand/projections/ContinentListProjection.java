package de.denarie.sand.projections;

import de.denarie.sand.domain.Continent;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "continentlist", types = { Continent.class })
public interface ContinentListProjection {
    Integer getId();
    String getName();
}
