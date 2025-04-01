package de.denarie.sand.repositories;

import de.denarie.sand.domain.Continent;
import de.denarie.sand.projections.ContinentListProjection;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "continent", path = "continent", excerptProjection= ContinentListProjection.class)
public interface ContinentRepository extends PagingAndSortingRepository<Continent, Long>, CrudRepository<Continent,Long> {
}
