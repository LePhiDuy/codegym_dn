package service;

import model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService{
    private static Map<Integer, Product> products;
    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "Iphone X", 1000000, "Iphone"));
        products.put(2, new Product(2, "Iphone 11", 2000000, "Iphone"));
        products.put(3, new Product(3, "Samsung A03", 5000000, "Samsung"));
        products.put(4, new Product(4, "Realme 11", 1000000, "Realme"));
        products.put(5, new Product(5, "Nokia 1080", 100000, "Nokia"));
        products.put(6, new Product(6, "Iphone 13", 70000000, "Iphone"));
    }
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }
}
