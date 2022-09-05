package vn.codegym.product_demo_md4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.product_demo_md4.entity.Category;

public interface ICategoryRepository extends JpaRepository<Category, Long> {
}
