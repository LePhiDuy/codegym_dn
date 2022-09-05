package vn.codegym.product_demo_md4.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.product_demo_md4.entity.Category;
import vn.codegym.product_demo_md4.repository.ICategoryRepository;
import vn.codegym.product_demo_md4.service.ICategoryService;

@Service
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;
    @Override
    public Iterable<Category> findAll() {
        return categoryRepository.findAll();
    }
}
