package lld.criteria.design.pattern.factories;

import lld.criteria.design.pattern.enums.Operator;
import lld.criteria.design.pattern.strategy.GreaterThanStrategy;
import lld.criteria.design.pattern.strategy.LessThanStrategy;
import lld.criteria.design.pattern.strategy.PriceComparisionStrategy;

public class PriceComparisionStrategyFactory {
    public static PriceComparisionStrategy create(Operator comparisionType){
        if(comparisionType.equals(Operator.GREATER_THAN)){
            return new GreaterThanStrategy();
        }
        else if(comparisionType.equals(Operator.LESS_THAN)){
            return new LessThanStrategy();
        }
        return null;
    }
}
