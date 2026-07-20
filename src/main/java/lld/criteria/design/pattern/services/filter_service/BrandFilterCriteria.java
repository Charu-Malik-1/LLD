package lld.criteria.design.pattern.services.filter_service;

import lld.criteria.design.pattern.models.Product;

import java.util.List;
import java.util.stream.Collectors;

/**
 * say u want to add the filter for brand
 */
public class BrandFilterCriteria implements Criteria {

    private final String brand;

    public BrandFilterCriteria(String brand) {
        this.brand = brand;
    }

    @Override
    public List<Product> satisfy(List<Product> products) {
        return products.stream().filter(product -> product.getName().equalsIgnoreCase(this.brand))
                .collect(Collectors.toList());
    }
}
