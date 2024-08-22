package com.kryspetrie.springdatademo.infrastructure.repository;

import com.kryspetrie.springdatademo.infrastructure.repository.entities.ZooEntity;
import jakarta.annotation.Nonnull;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.*;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.UUID;

@RepositoryRestResource(
        path = "zoo",
        collectionResourceDescription = @Description("Collection of zoos registered in the database."),
        itemResourceDescription = @Description("Simple zoo representation.")
)
@Repository
public interface ZooRepository extends
        CrudRepository<ZooEntity, UUID>,
        ListPagingAndSortingRepository<ZooEntity, UUID> {

    @RestResource
    Collection<ZooEntity> findByName(@Nonnull final String name);
}
