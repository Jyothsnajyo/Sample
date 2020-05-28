package com.sample.project.repository;

import com.sample.project.model.data.Articles;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CustomImplementation implements InterfaceToCustomizeMethods {

    @Autowired
    private EntityManager entityManager;

    public Session getSession() {
        return entityManager.unwrap(Session.class);
    }

    @Override
    public List<Articles> getArticles(Integer page, Integer limit){
        Criteria cr = getSession().createCriteria(Articles.class);
        //List<Articles> articlesWholeList = cr.list();
        cr.setMaxResults(limit);
        cr.setFirstResult((page - 1) * limit);
        List<Articles> paginatedList = cr.list();
        return paginatedList;
    }
}
