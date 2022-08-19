package com.example.demo.repository;

import com.example.demo.entity.Blog;
import com.example.demo.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICategoryRepository extends JpaRepository<Category, Long> {
    @Query(value = "select b.id, b.name, b.content, b.author, b.date_create, b.category_id " +
            "from category as c join blog as b on c.id = b.category_id where c.id = ?1", nativeQuery = true)
    List<Object> findBlogsByCategory(Long id);
}
