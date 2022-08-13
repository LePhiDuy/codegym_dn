package com.example.shopping_cart.Dto;

import java.util.HashMap;
import java.util.Map;

public class CartDto {
    private Map<ProductDto, Integer> products = new HashMap<>();

    public CartDto() {
    }

    public Map<ProductDto, Integer> getProducts() {
        return products;
    }

    public void setProducts(Map<ProductDto, Integer> products) {
        this.products = products;
    }

    public CartDto(Map<ProductDto, Integer> products) {
        this.products = products;
    }
    public void addProduct(ProductDto productDto) {
        if (products.containsKey(productDto)) {
            products.replace(productDto, products.get(productDto) + 1);
        } else {
            products.put(productDto, 1);
        }
    }
    public Integer countProductQuantity(){
        Integer productQuantity = 0;
        for (Map.Entry<ProductDto, Integer> entry : products.entrySet()) {
            productQuantity += entry.getValue();
        }
        return productQuantity;
    }

    public Integer countItemQuantity(){
        return products.size();
    }

    public Float countTotalPayment(){
        float payment = 0;
        for (Map.Entry<ProductDto, Integer> entry : products.entrySet()) {
            payment += entry.getKey().getPrice() * (float) entry.getValue();
        }
        return payment;
    }
    public void subProduct(ProductDto productDto) {
        for (Map.Entry<ProductDto, Integer> entry : products.entrySet()) {
            if (entry.getKey().getId().equals(productDto.getId())) {
                if (entry.getValue() > 1) {
                    products.replace(entry.getKey(), entry.getValue() - 1);
                } else {
                    products.remove(productDto);
                }
            }
        }
    }
}
