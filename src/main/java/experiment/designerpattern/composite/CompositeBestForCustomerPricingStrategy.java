package com.designerpattern.composite;

/**
 * 对消费者最低的价格
 *
 * @author haze
 * @date created at 2019-08-20 12:52
 */
public class CompositeBestForCustomerPricingStrategy extends CompositePricingStrategy {
    @Override
    public double getTotal(Sale sale) {
        double lowestTotal = Integer.MAX_VALUE;
        for (ISalesPricingStrategy strategy : strategyList) {
            double res = strategy.getTotal(sale);
            if (res < lowestTotal) {
                lowestTotal = res;
            }
        }
        return lowestTotal;
    }
}
