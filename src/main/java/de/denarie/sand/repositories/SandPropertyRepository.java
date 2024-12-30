package de.denarie.sand.repositories;

import de.denarie.sand.domain.SandProperty;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "property", path = "property")
public interface SandPropertyRepository extends PagingAndSortingRepository<SandProperty, Long>, CrudRepository<SandProperty,Long> {
}
