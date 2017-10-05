package com.blog.database.service;

import com.blog.database.domain.Blog;
import com.blog.database.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Mikhailenko Mikhail
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BlogService {

    final BlogRepository blogRepository;

    @Transactional
    public void addNode(Blog blog){
        blogRepository.save(blog);
    }

    @Transactional
    public void updateNote(Blog blog){
        blogRepository.saveAndFlush(blog);
    }

    @Transactional
    public Blog getById(Long id){
        return blogRepository.findOne(id);
    }

    @Transactional
    public void deleteNode(Long id){
        blogRepository.delete(id);
    }

    public List<Blog> allNode(){
        return blogRepository.findAll();
    }
}
