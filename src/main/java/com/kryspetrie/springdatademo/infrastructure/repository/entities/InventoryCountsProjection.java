package com.kryspetrie.springdatademo.infrastructure.repository.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "counts", types = { AnimalInventoryEntity.class })
public interface InventoryCountsProjection {
    int getSexMale();
    int getSexFemale();
    int getSexUnknown();
}