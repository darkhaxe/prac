package com.designerpattern.composite;

/**
 * @author haze
 * @date created at 2019-08-20 12:43
 */
public interface ISalesPricingStrategy {
    double getTotal(Sale sale);
}
