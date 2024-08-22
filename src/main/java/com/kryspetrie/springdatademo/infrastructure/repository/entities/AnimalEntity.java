package com.kryspetrie.springdatademo.infrastructure.repository.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import java.util.UUID;

@Table("animal")
@Entity
@Data
@AllArgsConstructor
public final class AnimalEntity {

    @Id
    @GeneratedValue
    final @NotNull UUID id;
    @GeneratedValue
    @LastModifiedDate
    private LocalDate updated;
    private @NotNull String name;
    private @NotNull String description;
    private @NotNull String conservationStatus;
}
