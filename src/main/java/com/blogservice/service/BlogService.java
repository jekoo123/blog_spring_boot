package com.blogservice.service;


import com.blogservice.dto.AddArticleRequest;
import com.blogservice.entity.Article;
import com.blogservice.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BlogService {
    private final BlogRepository blogRepository;

    public Article save(AddArticleRequest request){

        return blogRepository.save(request.toEntity());
    }
}
