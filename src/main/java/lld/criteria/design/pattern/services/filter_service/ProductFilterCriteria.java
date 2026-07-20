package lld.criteria.design.pattern.services.filter_service;

import lld.criteria.design.pattern.models.Product;
import lld.criteria.design.pattern.strategy.PriceComparisionStrategy;

import java.util.List;
import java.util.stream.Collectors;

/**
 * say u want to add the filter for price > 10
 */
public class ProductFilterCriteria implements Criteria {

    private final double price;
    private final PriceComparisionStrategy comparisionStrategies;

    public ProductFilterCriteria(double price, PriceComparisionStrategy priceCriteriaStrategy) {
        this.price = price;
        this.comparisionStrategies = priceCriteriaStrategy;
    }

    @Override
    public List<Product> satisfy(List<Product> products) {
        return products.stream().filter(product ->
                comparisionStrategies.compare(product.getPrice(),this.price))
                .collect(Collectors.toList());
    }
}
