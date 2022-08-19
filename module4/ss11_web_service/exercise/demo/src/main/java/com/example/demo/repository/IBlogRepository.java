package com.example.demo.repository;

import com.example.demo.entity.Blog;
import com.example.demo.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Long> {

}
