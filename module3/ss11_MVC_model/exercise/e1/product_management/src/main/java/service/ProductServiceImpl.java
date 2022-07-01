package service;

import model.Product;
import repository.IProductRepository;
import repository.ProductRepositoryImpl;

import java.util.List;

public class ProductServiceImpl implements IProductService{
    IProductRepository listProduct = new ProductRepositoryImpl();
    @Override
    public List<Product> findAll() {
        return listProduct.findAll();
    }

    @Override
    public void save(Product product) {
        listProduct.save(product);
    }

    @Override
    public void update(int id, Product product) {
        listProduct.update(id, product);
    }

    @Override
    public void remove(int id, Product product) {
        listProduct.remove(id, product);
    }

    @Override
    public Product findById(int id) {
        return listProduct.findById(id);
    }

    @Override
    public Product findByName(int name) {
        return listProduct.findByName(name);
    }
}
