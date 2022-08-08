package com.example.demo.service;

import com.example.demo.model.Blog;
import com.example.demo.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogService extends IGeneralService<Blog>{
    List<Blog> findAllByCategory(Category category);
    Page<Blog> searchByName(String name, Pageable pageable);
    List<Blog> findAllByNameContaining(String name);
}
