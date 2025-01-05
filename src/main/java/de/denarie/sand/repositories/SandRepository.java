package de.denarie.sand.repositories;

import de.denarie.sand.domain.Sand;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.UUID;

@RepositoryRestResource(collectionResourceRel = "sand", path = "sand")
public interface SandRepository extends PagingAndSortingRepository<Sand, Long>, CrudRepository<Sand,Long> {
    Page<Sand> findByLongnameLikeIgnoreCase(@Param("name") String name, Pageable pageable);
}
