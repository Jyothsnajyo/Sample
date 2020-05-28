package com.sample.project.controller;

import com.sample.project.model.request.LoginRequest;
import com.sample.project.model.request.UserSignUpRequest;
import com.sample.project.model.response.UserLoginResponse;
import com.sample.project.model.response.UserSignUpResponse;
import com.sample.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(path = "/register",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public UserSignUpResponse signUp(@RequestBody  UserSignUpRequest signUpRequest){
        System.out.println(signUpRequest.getPassword());
        System.out.println(signUpRequest.getRole());
        System.out.println(signUpRequest.getUsername());
        return userService.createUserService(signUpRequest);
    }

    @PostMapping(path = "/login",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public UserLoginResponse login(@RequestBody LoginRequest loginRequest){
        return userService.userLogin(loginRequest);
    }
}
