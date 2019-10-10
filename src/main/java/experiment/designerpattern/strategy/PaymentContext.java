package experiment.designerpattern.strategy;

/**
 * @author haze
 * @date created at 2018/2/25 下午2:19
 */
public class PaymentContext {
    private String userName = null;
    private double money = 0.0;
    //持有一个策略接口
    private PaymentStrategy strategy;

    public PaymentContext(String userName, double money, PaymentStrategy strategy) {
        this.userName = userName;
        this.money = money;
        this.strategy = strategy;
    }

    /**
     *
     */
    public void payNow() {
        this.strategy.pay(this);
    }

    public String getUserName() {
        return userName;
    }

    public double getMoney() {
        return money;
    }
}
