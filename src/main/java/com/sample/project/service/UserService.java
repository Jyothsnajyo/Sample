package com.sample.project.service;

import com.sample.project.model.request.LoginRequest;
import com.sample.project.model.request.UserSignUpRequest;
import com.sample.project.model.response.UserLoginResponse;
import com.sample.project.model.response.UserSignUpResponse;

public interface UserService {
    UserSignUpResponse createUserService(UserSignUpRequest request);

    UserLoginResponse userLogin(LoginRequest loginRequest);
}
