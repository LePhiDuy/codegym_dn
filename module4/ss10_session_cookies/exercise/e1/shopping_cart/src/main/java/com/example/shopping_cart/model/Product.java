package com.example.shopping_cart.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(columnDefinition = "decimal")
    private double price;
    @Column(columnDefinition = "text")
    private String description;
    private String urlImage;

}
