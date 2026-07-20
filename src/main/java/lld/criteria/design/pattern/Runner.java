package lld.criteria.design.pattern;

import lld.criteria.design.pattern.enums.Operator;
import lld.criteria.design.pattern.factories.PriceComparisionStrategyFactory;
import lld.criteria.design.pattern.models.Brand;
import lld.criteria.design.pattern.models.Category;
import lld.criteria.design.pattern.models.Product;
import lld.criteria.design.pattern.services.filter_service.*;

import java.util.List;

public class Runner {

    public static void main(String[] args) {

        Brand b1 = new Brand("Apple");
        Brand b2 = new Brand("Samsung");
        Brand b3 = new Brand("Oneplus");

        Category c1 = new Category("Electronics");

        Product p1 = new Product("iphone 12", 799.99, b1, c1);
        Product p2 = new Product("Galaxy S21", 1000, b2, c1);
        Product p3 = new Product("OnePlus 9", 699.99, b3, c1);

        List<Product> products = List.of(p1, p2, p3);

        /** brand should be Apple or Samsung*/
        Criteria cr1 = new BrandFilterCriteria("Apple");
        Criteria cr2 = new BrandFilterCriteria("Samsung");
        Criteria orCriteria = new OrFilterCriteria(List.of(cr1, cr2));
        List<Product> filteredProducts = orCriteria.satisfy(products);

        for (Product product : filteredProducts) {
            System.out.println(product.getName());
        }

        //price should be greater than 999
        Criteria priceFilterCriteria = new ProductFilterCriteria(999,
                PriceComparisionStrategyFactory.create(Operator.GREATER_THAN));

        /** (brand==apple or brand==samsung) and price > 999 */
        Criteria andCriteria = new AndFilterCriteria(List.of(orCriteria, priceFilterCriteria));
        filteredProducts = andCriteria.satisfy(products);

        for (Product product : filteredProducts) {
            System.out.println(product.getName());
        }

    }
}
