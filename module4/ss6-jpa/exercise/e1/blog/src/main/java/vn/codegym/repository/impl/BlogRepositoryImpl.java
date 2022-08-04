package vn.codegym.repository.impl;

import org.springframework.stereotype.Repository;
import vn.codegym.model.Blog;
import vn.codegym.repository.IBlogRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class BlogRepositoryImpl implements IBlogRepository {
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public List<Blog> findAll() {
        return entityManager.createQuery("select blog from Blog as blog", Blog.class).getResultList();
    }

    @Override
    public void save(Blog blog) {
        if (blog.getId() != null) {
            entityManager.merge(blog);
        } else {
            entityManager.persist(blog);
        }
    }

    @Override
    public Blog findById(Long id) {
        return entityManager.find(Blog.class, id);
    }

    @Override
    public void remove(Long id) {
        Blog blog = findById(id);
        if (blog != null) {
            entityManager.remove(blog);
        }
    }
}
