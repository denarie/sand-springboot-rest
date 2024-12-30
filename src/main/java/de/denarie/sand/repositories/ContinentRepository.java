package de.denarie.sand.repositories;

import de.denarie.sand.domain.Continent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "continent", path = "continent")
public interface ContinentRepository extends PagingAndSortingRepository<Continent, Long>, CrudRepository<Continent,Long> {
}
