package com.sample.project.logic.api;

import com.sample.project.model.request.UserSignUpRequest;
import org.springframework.stereotype.Service;

@Service
public interface KeycloakLogic {
    /**
     * creates a new user in keycloak and returns id
     */
    String createUserKeycloak(UserSignUpRequest signUpRequest);

    void assignUserRole(String id, String role);

    String userLogin(String username, String password);
}
