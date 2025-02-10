package de.denarie.sand.repositories;

import de.denarie.sand.domain.Person;
import de.denarie.sand.projections.PersonListProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "person", path = "person", excerptProjection= PersonListProjection.class)
public interface PersonRepository extends PagingAndSortingRepository<Person, Long>, CrudRepository<Person,Long> {
    Page<Person> findByNameLikeIgnoreCase(@Param("name") String name, Pageable pageable);
}
