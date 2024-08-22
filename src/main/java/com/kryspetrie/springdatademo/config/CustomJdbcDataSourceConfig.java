package com.kryspetrie.springdatademo.config;

import org.flywaydb.core.internal.jdbc.JdbcTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
public class CustomJdbcDataSourceConfig {

    @Bean
    @ConfigurationProperties("spring.jdbc")
    public DataSourceProperties jdbcDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    public DataSource jdbcDataSource() {
        return jdbcDataSourceProperties()
                .initializeDataSourceBuilder()
                .build();
    }

    @Bean
    public JdbcTemplate customJdbcTemplate(@Qualifier("jdbcDataSource") DataSource dataSource) throws SQLException {
        return new JdbcTemplate(dataSource.getConnection());
    }
}