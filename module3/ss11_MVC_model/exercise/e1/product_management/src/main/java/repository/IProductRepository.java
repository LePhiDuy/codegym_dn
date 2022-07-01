package repository;

import model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();

    void save(Product product);
    void update(int id, Product product);
    void remove(int id, Product product);
    Product findById(int id);
    Product findByName(int name);

}
