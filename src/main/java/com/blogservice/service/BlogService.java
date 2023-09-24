package com.blogservice.service;


import com.blogservice.dto.AddArticleRequest;
import com.blogservice.entity.Article;
import com.blogservice.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BlogService {
    private final BlogRepository blogRepository;

    public Article save(AddArticleRequest request){
        return blogRepository.save(request.toEntity());
    }
    public List<Article> findAll(){
        return blogRepository.findAll();
    }

    public Article findById(long id){
        return blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " +id));
    }

    public void delete (long id){
        blogRepository.deleteById(id);
    }


}
