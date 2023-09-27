package com.blogservice.dto;

import com.blogservice.entity.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

//글 추가 dto

//dto는 각 계층에서 데이터를 전달하는 데에 사용
//Controller에서 직접 엔티티에 가는게 좋지 않을까? ->
//dto에는 코드 독립성, 검증 로직 등등 다양한 이점이 있다
//생성 dto, 읽기 dto, 수정 dto, 삭제 dto 형식


@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddArticleRequest {
    private String title;
    private String content;


    public Article toEntity(){
        return Article.builder().title(title).content(content).build();
    }
    //캡슐화된 dto의 데이터를 Article 엔티티로
}
