package service;


import module.Product;

import java.sql.SQLException;
import java.util.List;

public interface IProductService {
    List<Product> findAll() throws SQLException;
    void save(Product product);
    boolean remove(int id);
    Product searchByID(int id);
}
