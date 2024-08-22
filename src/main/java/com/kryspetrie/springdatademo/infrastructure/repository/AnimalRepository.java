package com.kryspetrie.springdatademo.infrastructure.repository;

import com.kryspetrie.springdatademo.infrastructure.repository.entities.AnimalEntity;
import jakarta.annotation.Nonnull;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.Description;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.UUID;

@RepositoryRestResource(
        path = "animal",
        collectionResourceDescription = @Description("Collection of animals registered in the database."),
        itemResourceDescription = @Description("Simple animal representation, for use in inventory.")
)
@Repository
public interface AnimalRepository extends
        CrudRepository<AnimalEntity, UUID>,
        ListPagingAndSortingRepository<AnimalEntity, UUID> {

    @RestResource
    Collection<AnimalEntity> findByName(@Nonnull final String name);
}
