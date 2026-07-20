package lld.criteria.design.pattern.services.filter_service;

import lld.criteria.design.pattern.models.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OrFilterCriteria implements Criteria{
    private List<Criteria> criteriaList;

    public OrFilterCriteria(List<Criteria> criteriaList){
        // in criteria list we are adding brandFilterCriteria("Apple")
        this.criteriaList=criteriaList;
    }

    @Override
    public List<Product> satisfy(List<Product> products){
//        products -> [{id: 1, brand: "Apple"}, {id: 2, brand: "Samsung"}, {id: 3, brand: "OnePlus"}]
        // go to every single criteria

        // make the product pass throgh any single criteria

        // if product fails even one of them then dont add them in the answer
        return products.stream()
                .filter(product -> criteriaList.stream()
                .anyMatch(criteria -> !criteria.satisfy(List.of(product)).isEmpty())
                )
        .collect(Collectors.toList());
    }
}
