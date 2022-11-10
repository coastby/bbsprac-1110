package com.example.prac1110.repository;

import com.example.prac1110.entity.Article2;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article2, Long> {
}
