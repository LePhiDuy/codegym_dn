package repository;

import model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepositoryImpl implements IProductRepository{
    static Map<Integer, Product> listProduct;
    static {
        listProduct = new HashMap<>();
        listProduct.put(1, new Product(1, "Phone", 200000));
        listProduct.put(2, new Product(2, "Table", 200000));
        listProduct.put(3, new Product(3, "Laptop", 50000));
        listProduct.put(4, new Product(4, "Clothes", 100000));
        listProduct.put(5, new Product(5, "Car", 20000000));
    }
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(listProduct.values());
    }

    @Override
    public void save(Product product) {
        listProduct.put(product.getId(), product);
    }

    @Override
    public void update(int id, Product product) {
        listProduct.put(id, product);
    }

    @Override
    public void remove(int id, Product product) {
        listProduct.remove(id, product);
    }

    @Override
    public Product findById(int id) {
        return listProduct.get(id);
    }

    @Override
    public Product findByName(int name) {
        return listProduct.get(name);
    }
}
