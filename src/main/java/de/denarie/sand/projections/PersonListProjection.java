package de.denarie.sand.projections;

import de.denarie.sand.domain.Person;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "personlist", types = { Person.class })
public interface PersonListProjection {
    Integer getId();
    String getName();
}
