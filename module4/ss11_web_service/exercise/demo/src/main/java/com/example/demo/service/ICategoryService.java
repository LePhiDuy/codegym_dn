package com.example.demo.service;

import com.example.demo.entity.Blog;
import com.example.demo.entity.Category;

import java.util.List;

public interface ICategoryService extends IGeneralService<Category> {
    List<Object> findBlogsByCategory(Long id);
}
