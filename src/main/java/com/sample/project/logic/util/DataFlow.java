package com.sample.project.logic.util;

import com.sample.project.model.request.UserSignUpRequest;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;

import java.util.Collections;

public final class DataFlow {
    private DataFlow() {}
    public static UserRepresentation getKeycloakUserRepresentation(UserSignUpRequest signUpRequest) {
        System.out.println(signUpRequest.getPassword());
        System.out.println(signUpRequest.getRole());
        System.out.println(signUpRequest.getUsername());
        UserRepresentation userToBeSaved = new UserRepresentation();
        userToBeSaved.setEnabled(true);
        userToBeSaved.setUsername(signUpRequest.getUsername());
        CredentialRepresentation password = new CredentialRepresentation();
        password.setType(CredentialRepresentation.PASSWORD);
        password.setValue(signUpRequest.getPassword());
        userToBeSaved.setCredentials(Collections.singletonList(password));
        return userToBeSaved;
    }
}