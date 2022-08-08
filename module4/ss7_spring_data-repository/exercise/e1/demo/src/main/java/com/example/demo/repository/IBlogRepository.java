package com.example.demo.repository;

import com.example.demo.model.Blog;
import com.example.demo.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogRepository extends PagingAndSortingRepository<Blog, Long> {
    Page<Blog> findAll(Pageable pageable);
    List<Blog> findAllByCategory(Category category);
    @Query(value = "select b.* from blog b where name like ?1",
            countQuery = "select p.* from blog b where name like ?1", nativeQuery = true)
    Page<Blog> searchByName(String name, Pageable pageable);
    Page<Blog> findBlogsByNameContaining(String name, Pageable pageable);
    List<Blog> findAllByNameContaining(String name);
}
