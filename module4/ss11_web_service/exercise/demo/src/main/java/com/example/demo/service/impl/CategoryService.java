package com.example.demo.service.impl;

import com.example.demo.entity.Blog;
import com.example.demo.entity.Category;
import com.example.demo.repository.IBlogRepository;
import com.example.demo.repository.ICategoryRepository;
import com.example.demo.service.IBlogService;
import com.example.demo.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;
    @Override
    public Iterable<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public List<Object> findBlogsByCategory(Long id) {
        return categoryRepository.findBlogsByCategory(id);
    }
}
