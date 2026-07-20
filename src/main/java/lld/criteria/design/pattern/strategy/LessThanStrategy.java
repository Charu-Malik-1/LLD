package lld.criteria.design.pattern.strategy;

public class LessThanStrategy implements PriceComparisionStrategy{
    @Override
    public boolean compare(double price1, double price2) {
        if(price1<price2)
            return true;
        return false;
    }
}
