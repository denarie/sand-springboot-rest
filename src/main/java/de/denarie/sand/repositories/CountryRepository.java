package de.denarie.sand.repositories;

import de.denarie.sand.domain.Continent;
import de.denarie.sand.domain.Country;
import de.denarie.sand.domain.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "country", path = "country")
public interface CountryRepository extends PagingAndSortingRepository<Country, Long>, CrudRepository<Country,Long> {
    Page<Country> findByNameDeLikeIgnoreCase(@Param("name") String name, Pageable pageable);
}
