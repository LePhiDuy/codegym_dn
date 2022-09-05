package vn.codegym.product_demo_md4.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vn.codegym.product_demo_md4.entity.Product;

public interface IProductRepository extends JpaRepository<Product, Long> {
    Page<Product> findAll(Pageable pageable);
    Page<Product> findAllByNameContaining(String name, Pageable pageable);
    Page<Product> findByPriceGreaterThanEqual(Double price, Pageable pageable);
    Page<Product> findByManufacturerContaining(String manufacturer, Pageable pageable);
    @Query(value = "select p.* from product p\n" +
            "join category c on p.category_id= c.id\n" +
            "where p.name like ?1 or p.price like ?1 or p.exp_date like ?1 or p.manufacturer like ?1 or c.name like ?1"
            , countQuery= "select p.* from product p\n" +
            "join category c on p.category_id= c.id\n" +
            "where p.name like ?1 or p.price like ?1 or p.exp_date like ?1 or p.manufacturer like ?1 or c.name like ?1", nativeQuery= true)
    Page<Product> findAllByValue(String val, Pageable pageable);
}
