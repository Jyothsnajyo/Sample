package com.sample.project.service.Impl;

import com.sample.project.logic.api.KeycloakLogic;
import com.sample.project.model.data.Users;
import com.sample.project.model.request.LoginRequest;
import com.sample.project.model.request.UserSignUpRequest;
import com.sample.project.model.response.UserLoginResponse;
import com.sample.project.model.response.UserSignUpResponse;
import com.sample.project.repository.UsersRepository;
import com.sample.project.service.UserService;
import com.sample.project.service.util.DataFlow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private KeycloakLogic keycloakLogic;

    @Override
    public UserSignUpResponse createUserService(UserSignUpRequest request) {

        //~ check for email uniqueness
        if(request.getEmail() != null)
        {
            if(usersRepository.findByEmail(request.getEmail())!=null)
            {
                throw new RuntimeException("A user already exists with the given email");
            }
        }
        if(request.getRole() == null){
            request.setRole("USER");
        }
        System.out.println(request.getRole());
        String userId = keycloakLogic.createUserKeycloak(request);
        keycloakLogic.assignUserRole(userId, request.getRole());
        UserSignUpResponse userSignUpResponse = null;
        Users user = usersRepository.save(DataFlow.getUserEntity(userId, request));
        userSignUpResponse = DataFlow.getSignUpResponse(user);
        return userSignUpResponse;
    }

    @Override
    public UserLoginResponse userLogin(LoginRequest loginRequest) {
        Users user = null;
//        if((user = usersRepository.findByUsername(username)) == null){
//            throw new RuntimeException("Invalid username");
//        }
        String token = keycloakLogic.userLogin(loginRequest.getUsername(), loginRequest.getPassword());
        UserLoginResponse response = new UserLoginResponse();
        response.setMessage("success");
        response.setAccessToken(token);
        return response;
    }
}
