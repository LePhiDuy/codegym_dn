package service;

import model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements IProductService {
    private static final Map<Integer, Product> products;
    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "Iphone", 10000000, "Apple"));
        products.put(2, new Product(2, "Television", 500000000, "Samsung"));
        products.put(3, new Product(3, "Samsung A03S", 1000000, "Samsung"));
        products.put(4, new Product(4, "Laptop", 10000000, "Dell"));
        products.put(5, new Product(5, "Watch", 10000000, "Rolex"));
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
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void delete(int id) {
        products.remove(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> result = new ArrayList<>();
        for (Product product: products.values()) {
            if (product.getName().contains(name)) {
                result.add(product);
            }
        }
        return result;
    }
}
