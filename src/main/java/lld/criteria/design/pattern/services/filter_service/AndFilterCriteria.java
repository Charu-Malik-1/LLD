package lld.criteria.design.pattern.services.filter_service;

import lld.criteria.design.pattern.models.Product;

import java.util.List;
import java.util.stream.Collectors;

public class AndFilterCriteria implements Criteria{
    private List<Criteria> criteriaList;

    public AndFilterCriteria(List<Criteria> criteriaList){
        this.criteriaList=criteriaList;
    }

    @Override
    public List<Product> satisfy(List<Product> products){
        // go to every single criteria

        // make the product pass throgh evenry single criteria

        // if product fails even one of them then dont add them in the answer
        return products.stream()
                .filter(product -> criteriaList.stream()
                .allMatch(criteria -> !criteria.satisfy(List.of(product)).isEmpty())
                )
        .collect(Collectors.toList());
    }
}
