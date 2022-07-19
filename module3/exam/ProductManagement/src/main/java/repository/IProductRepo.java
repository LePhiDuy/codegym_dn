package repository;

import model.Product;

import java.util.List;

public interface IProductRepo {
    public List<Product> getAll();
    public Product selectProductByID(int id);
    public List<Product> search(String productName, String price, String category, String color);
    public void add(Product product);
    public void update(Product product);
    public void delete(int id);
}
