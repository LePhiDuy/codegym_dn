package service;

import module.Product;
import repository.IProductRepository;
import repository.ProductReopsitoryImpl;

import java.sql.SQLException;
import java.util.List;

public class ProductServiceImpl implements IProductService{
    private IProductRepository productRepository = new ProductReopsitoryImpl();
    @Override
    public List<Product> findAll() throws SQLException {
        return productRepository.findAll();
    }
    @Override
    public void save(Product product) {
        productRepository.save(product);
    }
    @Override
    public boolean remove(int id) {
        return productRepository.remove(id);
    }
    @Override
    public Product searchByID(int id) {
        return productRepository.searchByID(id);
    }
}
