package com.sample.project.repository;

import com.sample.project.model.data.Articles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticlesRepository extends JpaRepository<Articles,Integer> {
}
