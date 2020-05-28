package com.sample.project.repository;

import com.sample.project.model.data.Articles;
import org.hibernate.Session;

import java.util.List;

public interface InterfaceToCustomizeMethods {

    List<Articles> getArticles(Integer page, Integer limit);
}
