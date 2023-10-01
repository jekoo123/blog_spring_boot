package com.blogservice.controller;

import com.blogservice.dto.AddArticleRequest;
import com.blogservice.dto.ArticleResponse;
import com.blogservice.dto.UpdateArticleRequest;
import com.blogservice.entity.Article;
import com.blogservice.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class BlogApiController {
    private final BlogService blogService;
    @PostMapping("/api/articles")
    public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequest request){
        //Request body로 받은 json을 자바 객체로 바까줌 (AddArticleRequest dto 객체임!!)
        Article savedArticle = blogService.save(request);
        //그렇게 바꾼 객체 (request)를 가지고 Service 로직 적용
        return ResponseEntity.status(HttpStatus.CREATED).body(savedArticle);
        //응답 바디로 savedArticle을 전달, 201 created 반환
    }

    @GetMapping("/api/articles")
    public ResponseEntity<List<ArticleResponse>> findAllArticles(){
        List<ArticleResponse> articles = blogService.findAll()
                .stream()
                .map(ArticleResponse::new)
                .toList();
        //전체조회 api는 여기서 findAll()로 구현됨

        return ResponseEntity.ok()
                .body(articles);
        //200반환
    }

    @GetMapping("/api/articles/{id}")
    //url 경로에서 추출
    public ResponseEntity<ArticleResponse> findArticle(@PathVariable long id){
        Article article = blogService.findById(id);
        return ResponseEntity.ok().body(new ArticleResponse(article));
    }

    @DeleteMapping("/api/articles/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable long id){
        blogService.delete(id);
        return ResponseEntity.ok()
                .build();
    }

    @PutMapping("/api/articles/{id}")
    public ResponseEntity<Article> updateArticle(@PathVariable long id,
        @RequestBody UpdateArticleRequest request){
        Article updatedArticle = blogService.update(id, request);

        return ResponseEntity.ok()
                .body(updatedArticle);
    }


}
