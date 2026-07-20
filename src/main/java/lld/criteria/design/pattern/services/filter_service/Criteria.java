package lld.criteria.design.pattern.services.filter_service;

import lld.criteria.design.pattern.models.Product;

import java.util.List;

public interface Criteria {
    List<Product> satisfy(List<Product> products);
}
