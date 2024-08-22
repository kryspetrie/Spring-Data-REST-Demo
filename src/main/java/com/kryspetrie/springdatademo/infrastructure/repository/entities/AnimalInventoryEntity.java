package com.kryspetrie.springdatademo.infrastructure.repository.entities;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import java.util.UUID;

@Table("animal_inventory")
@Entity
public record AnimalInventoryEntity(
        @Id
        @Nonnull @GeneratedValue UUID id,
        @GeneratedValue @LastModifiedDate LocalDate updated,
        @Column(name = "animal_id")
        @Nonnull UUID animalId,
        @Column(name = "zoo_id")
        @Nonnull UUID zooId,
        int sexMale,
        int sexFemale,
        int sexUnknown) {
}
