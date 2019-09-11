package com.designerpattern.composite;

/**
 * @author haze
 * @date created at 2019-08-20 12:47
 */
public class AbsoluteDiscountOverThresholdPricingStrategy implements ISalesPricingStrategy {
    /**
     * 绝对值折扣
     */
    private double discount;
    /**
     * 阈值
     */
    private double threshold;

    @Override
    public double getTotal(Sale sale) {
        return 0;
    }
}
