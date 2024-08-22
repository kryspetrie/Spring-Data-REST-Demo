package com.kryspetrie.springdatademo.infrastructure.repository.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import java.util.UUID;

@Table("zoo")
@Entity
public record ZooEntity(
        @Id @NotNull @GeneratedValue UUID id,
        @GeneratedValue @LastModifiedDate LocalDate updated,
        @NotNull String name,
        @NotNull String location) {
}
