package designerpattern.strategy;

/**
 * @author haze
 * @date created at 2018/2/25 下午2:18
 */
public interface PaymentStrategy {
    /**
     *
     */
    void pay(PaymentContext ctx);
}
