package com.blogservice.dto;

import com.blogservice.entity.Article;


//모든 글 확인 dto (읽기 dto)

public class ArticleListViewResponse {
    private final Long id;
    private final String title;
    private final String content;
    //바뀌지 않고 그저 Read dto니까 final 붙여주자

    public ArticleListViewResponse(Article article){
        this.id = article.getId();
        this.title = article.getTitle();
        this.content = article.getContent();
    }
}
