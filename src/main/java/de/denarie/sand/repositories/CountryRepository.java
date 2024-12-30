package de.denarie.sand.repositories;

import de.denarie.sand.domain.Continent;
import de.denarie.sand.domain.Country;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "country", path = "country")
public interface CountryRepository extends PagingAndSortingRepository<Country, Long>, CrudRepository<Country,Long> {
}
