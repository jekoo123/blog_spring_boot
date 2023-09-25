package com.blogservice.repository;

import com.blogservice.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;


//JpaRepository 상속받음 <엔티티 명, 해당 엔티티 PK 자료형>
public interface BlogRepository extends JpaRepository<Article, Long> {
}
