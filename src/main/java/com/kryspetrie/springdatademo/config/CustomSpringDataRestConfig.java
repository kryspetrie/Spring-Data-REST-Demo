package com.kryspetrie.springdatademo.config;

import com.kryspetrie.springdatademo.infrastructure.repository.entities.AnimalEntity;
import com.kryspetrie.springdatademo.infrastructure.repository.entities.AnimalInventoryEntity;
import com.kryspetrie.springdatademo.infrastructure.repository.entities.ZooEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

@Configuration
public class CustomSpringDataRestConfig {

    @Bean
    public RepositoryRestConfigurer repositoryRestConfigurer() {
        return RepositoryRestConfigurer.withConfig(config -> {
            // Expose all the primary key ids for entities
            config.exposeIdsFor(AnimalEntity.class, AnimalInventoryEntity.class, ZooEntity.class);
        });
    }
}
