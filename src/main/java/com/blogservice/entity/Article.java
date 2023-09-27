package com.blogservice.entity;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
//엔티티 매핑, JPA로 DB랑 연결

@Data
//@Setter, @Getter, 생성자까지 포함

@NoArgsConstructor
//기본 생성자 생성(파라미터 x)

public class Article {
    //Article이라는 테이블 생성 (이 안에다가 각 열 정의)

    @CreatedDate
    //엔티티 생성될때 시각을 자동 설정
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @LastModifiedDate
    //엔티티가 수정될때마다 자동 설정
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Id
    //PK
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //엔티티의 PK를 자동 생성하기 위한 전략
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @Builder
    //롬복 빌더 패턴 생성자
    public Article(String title, String content){
        this.title = title;
        this.content = content;
    }

    //수정 메소드
    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }

}
