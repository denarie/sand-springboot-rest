package de.denarie.sand.repositories;

import de.denarie.sand.domain.Link;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "link", path = "link")
public interface LinkRepository extends PagingAndSortingRepository<Link, Long>, CrudRepository<Link,Long> {
}
