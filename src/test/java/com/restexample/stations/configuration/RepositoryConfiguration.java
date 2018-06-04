package com.restexample.stations.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.restexample.stations.domain"})
@EnableJpaRepositories(basePackages = {"com.restexample.stations.repositories"})
@EnableTransactionManagement
public class RepositoryConfiguration {
}
