package designerpattern.composite;

/**
 * 百分比折扣计算策略
 * @author haze
 * @date created at 2019-08-20 12:44
 */
public class PercentageDiscountPricingStrategy implements ISalesPricingStrategy {
    private double pecentage;

    @Override
    public double getTotal(Sale sale) {
        return sale.getPreDiscountTotal() * pecentage;
    }
}
