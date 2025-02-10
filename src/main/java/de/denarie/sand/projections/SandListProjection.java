package de.denarie.sand.projections;

import de.denarie.sand.domain.Sand;
import org.springframework.data.rest.core.config.Projection;

import java.math.BigDecimal;

@Projection(name = "sandlist", types = { Sand.class })
public interface SandListProjection {
    Integer getId();
    String getName();
    BigDecimal getLatitude();
    BigDecimal getLongitude();
}
