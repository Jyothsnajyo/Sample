package com.sample.project.config;

import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Spring Keycloak Integration requires a bean of type {@code} KeycloakSpringBootConfigResolver
 */
@Configuration
public class KeycloakSpringBootConfigResolverConfig {
    @Bean
    public KeycloakSpringBootConfigResolver KeycloakConfigResolver() {
        return new KeycloakSpringBootConfigResolver();
    }
}