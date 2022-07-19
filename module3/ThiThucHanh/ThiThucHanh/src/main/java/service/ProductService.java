package service;

import dao.ProductDAO;
import model.Product;

import java.util.List;

public class ProductService {
    private ProductDAO productDAO = new ProductDAO();

    public List<Product> getAll() {
        return  productDAO.getAll();
    }
    public Product selectProductByID(int id) {
        return productDAO.selectProductByID(id);
    }

    public List<Product> search(String productName, String price, String category, String color) {
        return productDAO.search(productName, price, category, color);
    }

    public void add(Product product) {
        productDAO.add(product);
    }

    public void update(Product product) {
        productDAO.update(product);
    }

    public void delete(int id) {
        productDAO.delete(id);
    }
}
