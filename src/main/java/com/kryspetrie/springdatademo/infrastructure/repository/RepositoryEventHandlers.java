package com.kryspetrie.springdatademo.infrastructure.repository;

import com.kryspetrie.springdatademo.infrastructure.repository.entities.AnimalEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.rest.core.annotation.HandleAfterCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

@Slf4j
@RepositoryEventHandler
@Component
public class RepositoryEventHandlers {

    @HandleAfterCreate
    public void handleAnimalSave(AnimalEntity entity) {
        log.atInfo().log("Saving animal: " + entity);
    }
}
