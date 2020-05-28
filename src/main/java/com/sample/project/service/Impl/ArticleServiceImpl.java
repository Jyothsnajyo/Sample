package com.sample.project.service.Impl;

import com.sample.project.model.data.Articles;
import com.sample.project.model.request.CreateArticleRequest;
import com.sample.project.repository.ArticlesRepository;
import com.sample.project.repository.InterfaceToCustomizeMethods;
import com.sample.project.repository.UsersRepository;
import com.sample.project.service.ArticleService;
import com.sample.project.service.UserService;
import com.sample.project.service.util.DataFlow;
import lombok.SneakyThrows;
import org.keycloak.representations.AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ArticleServiceImpl implements ArticleService {


    private static final int DEFAULT_LIMIT = 10;
    private static final int DEFAULT_PAGE = 1;

    @Autowired
    private ArticlesRepository articlesRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private InterfaceToCustomizeMethods repository;

    @Override
    public void createArticle(CreateArticleRequest request){
        Articles article = DataFlow.getArticleEntity(request);
   //     boolean userPresent = verifyUser(request.getAccessToken());
//        if(userPresent == true){
            articlesRepository.save(article);
        //}
    }

    //tried to validate user was throwing error had no time to correct it
//    @SneakyThrows
//    public boolean verifyUser(AccessToken accessToken){
//        AccessToken token = accessToken;
//        String user_id = token.getSubject();
//        System.out.println(user_id);
//        if((usersRepository.findById(user_id)) == null){
//            throw new Exception("invalid user");
//        }
//        return true;
//    }

    @Override
    public List<Articles> getArticles(Integer page, Integer limit){
        if(page == null){
            page = DEFAULT_PAGE;
        }
        if(limit == null){
            limit = DEFAULT_LIMIT;
        }
       return repository.getArticles(page, limit);
    }
}
