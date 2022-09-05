package vn.codegym.product_demo_md4.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.product_demo_md4.entity.Product;

public interface IProductService {
    Page<Product> findAll(Pageable pageable);
    void save(Product product);
    Page<Product> find(String searchBy, String keyword, Pageable pageable);
    void delete(Long id);
}
