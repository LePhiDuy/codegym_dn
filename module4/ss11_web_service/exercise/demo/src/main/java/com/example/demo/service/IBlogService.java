package com.example.demo.service;

import com.example.demo.entity.Blog;
import com.example.demo.entity.Category;

import java.util.List;
import java.util.Optional;

public interface IBlogService extends IGeneralService<Blog>{
    Optional<Blog> findById(Long id);
}
