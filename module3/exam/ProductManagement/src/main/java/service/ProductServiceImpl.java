package service;

import model.Product;
import repository.IProductRepo;
import repository.ProductRepoImpl;

import java.util.List;

public class ProductServiceImpl implements IProductService{
    private IProductRepo productRepo = new ProductRepoImpl();
    @Override
    public List<Product> getAll() {
        return productRepo.getAll();
    }

    @Override
    public Product selectProductByID(int id) {
        return productRepo.selectProductByID(id);
    }

    @Override
    public List<Product> search(String productName, String price, String category, String color) {
        return productRepo.search(productName, price, category, color);
    }

    @Override
    public void add(Product product) {
        productRepo.add(product);
    }

    @Override
    public void update(Product product) {
        productRepo.update(product);
    }

    @Override
    public void delete(int id) {
        productRepo.delete(id);
    }
}
