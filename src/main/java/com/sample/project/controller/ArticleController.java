package com.sample.project.controller;

import com.sample.project.model.data.Articles;
import com.sample.project.model.request.CreateArticleRequest;
import com.sample.project.model.request.LoginRequest;
import com.sample.project.model.response.GenericResponse;
import com.sample.project.model.response.UserLoginResponse;
import com.sample.project.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.persistence.PreUpdate;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @PostMapping(value = "/articles",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public GenericResponse createArticle(@RequestBody CreateArticleRequest request){
        articleService.createArticle(request);
        return new GenericResponse("new article created");
    }

    @GetMapping(value = "/articles", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Articles> getArticles(@RequestParam(required = false) Integer page,
                                      @RequestParam(required = false) Integer limit){
        return articleService.getArticles(page, limit);
    }
}
