package com.designerpattern.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @author haze
 * @date created at 2019-08-20 12:49
 */
public abstract class CompositePricingStrategy implements ISalesPricingStrategy {

    protected List<ISalesPricingStrategy> strategyList;

    void add(ISalesPricingStrategy strategy) {
        if (strategyList == null) {
            strategyList = new ArrayList<>();
        }
        strategyList.add(strategy);
    }

    public abstract double getTotal(Sale sale);
}
