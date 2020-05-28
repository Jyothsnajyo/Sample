package com.sample.project.logic.impl;

import com.sample.project.logic.api.KeycloakLogic;
import com.sample.project.logic.util.DataFlow;
import com.sample.project.model.request.UserSignUpRequest;
import com.sample.project.config.KeycloakClientConfig;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.representations.AccessTokenResponse;
import org.keycloak.representations.idm.RoleRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.Response;
import java.util.Collections;

@Component
public class KeycloakLogicImpl implements KeycloakLogic {

    @Autowired
    private KeycloakClientConfig config;

    @Override
    public String createUserKeycloak(UserSignUpRequest signUpRequest) {
        UserRepresentation userToBeSaved = DataFlow.getKeycloakUserRepresentation(signUpRequest);
        Response createUserResponse = config.getKeycloakAdminClient().realm(config.getRealm()).users().create(userToBeSaved);
        if(createUserResponse.getStatus()!=201)
        {
            throw new RuntimeException("either Keycloak is not running or user is already present in keycloak but not in database");
        }
        return createUserResponse.getLocation().getPath().replaceAll(".*/([^/]+)$", "$1");
    }

    @Override
    public void assignUserRole(String id, String role) {
        try {
            RoleRepresentation roleRep = config.getKeycloakAdminClient().realm(config.getRealm()).roles().get(role).toRepresentation();
            config.getKeycloakAdminClient().realm(config.getRealm()).users().get(id).roles().realmLevel().add(Collections.singletonList(roleRep));
        }
        catch (Exception e)
        {
            throw new RuntimeException("exception in assigning a role in keycloak.check whether the role is present in keycloak");
        }
    }

    @Override
    public String userLogin(String username, String password) {
        Keycloak authClient = config.getKeycloakAuthClient(username, password);
        AccessTokenResponse accessTokenResponse = null;
        try
        {
            accessTokenResponse = authClient.tokenManager().grantToken();
        }
        catch(Exception e)
        {
            throw new RuntimeException("invalid password");
        }
        return accessTokenResponse.getToken();
    }
}
