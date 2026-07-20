package lld.criteria.design.pattern.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private String name;
    private double price;
    private Brand brand;
    private Category category;

    public Product(String name, double price, Brand brand, Category category) {
        this.name = name;
        this.price = price;
        this.brand = brand;
        this.category = category;
    }
}
