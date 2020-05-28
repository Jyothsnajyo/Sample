package com.sample.project.config;

import lombok.Getter;
import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class KeycloakClientConfig {

    @Value("${keycloak.auth-server-url}")
    private String serverURL;

    @Value("${keycloak.resource}")
    private String resource;

    @Value("${keycloak.realm}")
    private String realm;

    @Value("${keycloak.credentials.secret}")
    private String secret;

    public Keycloak getKeycloakAdminClient() {
        return KeycloakBuilder.builder()
                .serverUrl(serverURL)
                .realm(realm)
                .clientId(resource)
                .clientSecret(secret)
                .grantType(OAuth2Constants.CLIENT_CREDENTIALS)
                .build();
    }

    public Keycloak getKeycloakAuthClient(final String username, final String password) {
        return KeycloakBuilder.builder()
                .username(username)
                .password(password)
                .serverUrl(serverURL)
                .realm(realm)
                .clientId(resource)
                .clientSecret(secret)
                .grantType(OAuth2Constants.PASSWORD)
                .build();
    }
}
