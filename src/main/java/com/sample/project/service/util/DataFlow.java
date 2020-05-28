package com.sample.project.service.util;

import com.sample.project.model.data.Articles;
import com.sample.project.model.data.Users;
import com.sample.project.model.request.CreateArticleRequest;
import com.sample.project.model.request.UserSignUpRequest;
import com.sample.project.model.response.UserSignUpResponse;

public class DataFlow {
    public static Users getUserEntity(String userId, UserSignUpRequest signUpRequest) {
        Users user = new Users();
        user.setId(userId);
        user.setAddress(signUpRequest.getAddress());
        user.setEmail(signUpRequest.getEmail());
        user.setUsername(signUpRequest.getUsername());
       return user;
    }

    public static UserSignUpResponse getSignUpResponse(Users user) {
        return new UserSignUpResponse(user.getId(), "New user created");
    }

    public static Articles getArticleEntity(CreateArticleRequest request){
        Articles article = new Articles();
        article.setAuthor(request.getAuthor());
        article.setBody(request.getBody());
        article.setTitle(request.getTitle());
        return article;
    }

}

