package com.sample.project.service;

import com.sample.project.model.data.Articles;
import com.sample.project.model.request.CreateArticleRequest;

import java.util.List;

public interface ArticleService {
    void createArticle(CreateArticleRequest request);

    List<Articles> getArticles(Integer page, Integer limit);
}
