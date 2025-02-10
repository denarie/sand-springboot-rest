package de.denarie.sand.projections;

import de.denarie.sand.domain.Country;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "countrylist", types = { Country.class })
public interface CountryListProjection {
    Integer getId();
    String getNameDe();
}
