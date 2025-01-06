package de.denarie.sand.repositories;

import de.denarie.sand.domain.Continent;
import de.denarie.sand.domain.Country;
import de.denarie.sand.domain.Person;
import de.denarie.sand.domain.Sand;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "country", path = "country")
public interface CountryRepository extends PagingAndSortingRepository<Country, Long>, CrudRepository<Country,Long> {
    Page<Country> findByNameDeLikeIgnoreCase(@Param("name") String name, Pageable pageable);

    @Query(value = "SELECT distinct(s.country) FROM Sand s")
    Page<Country> findAllCountriesWithSands(Pageable pageable);

    @Query(value = "select co from Country co join co.continents ci where ci.id = :continentId")
    Page<Country> findByContinentIdWithPagination(@Param("continentId") Integer continentId, Pageable pageable);
}
