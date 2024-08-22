package com.kryspetrie.springdatademo.infrastructure.repository;

import com.kryspetrie.springdatademo.infrastructure.repository.entities.AnimalInventoryEntity;
import jakarta.annotation.Nonnull;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.Description;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.UUID;


@RepositoryRestResource(
        path = "inventory",
        collectionResourceDescription = @Description("Collection representing the inventory of animals at zoos."),
        itemResourceDescription = @Description("Animal and Zoo linkage entity.")
)
@Repository
public interface AnimalInventoryRepository extends
        CrudRepository<AnimalInventoryEntity, UUID>,
        ListPagingAndSortingRepository<AnimalInventoryEntity, UUID> {

    @RestResource
    Collection<AnimalInventoryEntity> findByAnimalId(@Nonnull final String animalId);

    @RestResource
    Collection<AnimalInventoryEntity> findByZooId(@Nonnull final String zooId);

    @RestResource
    @Query("SELECT * FROM animal_inventory i JOIN animal a ON i.animal_id = a.id WHERE name = :name")
    Collection<AnimalInventoryEntity> findByAnimalName(@Nonnull final String name);

    @RestResource
    @Query("SELECT * FROM animal_inventory i JOIN zoo z ON i.zoo_id = z.id WHERE name = :name")
    Collection<AnimalInventoryEntity> findByZooName(@Nonnull final String name);
}
