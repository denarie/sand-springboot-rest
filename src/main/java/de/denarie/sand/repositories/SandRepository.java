package de.denarie.sand.repositories;

import de.denarie.sand.domain.Sand;
import de.denarie.sand.projections.SandListProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;


@RepositoryRestResource(collectionResourceRel = "sand", path = "sand", excerptProjection= SandListProjection.class)
public interface SandRepository extends PagingAndSortingRepository<Sand, Long>, CrudRepository<Sand,Long> {
    Page<Sand> findByLongnameLikeIgnoreCase(@Param("name") String name, Pageable pageable);
    Page<Sand> findByCountryId(@Param("countryId") Integer countryId, Pageable pageable);
    Page<Sand> findByPersonsId(@Param("personId") Integer personId, Pageable pageable);

    @Query(value = "SELECT s FROM Sand s join s.country co join co.continents ci where ci.id = :continentId")
    Page<Sand> findAllSandsByContinentWithPagination(@Param("continentId") Integer continentId, Pageable pageable);

    @Query(value = "SELECT s FROM Sand s join s.country co join co.continents ci where ci.id = :continentId")
    List<Sand> findAllSandsByContinent(@Param("continentId") Integer continentId);
}
