package vn.codegym.product_demo_md4.service;

import vn.codegym.product_demo_md4.entity.Category;

public interface ICategoryService {
    Iterable<Category> findAll();
}
