package experiment.designerpattern.strategy;

/**
 * @author haze
 * @date created at 2018/2/25 下午2:24
 */
public class YuanCash implements PaymentStrategy {
    @Override
    public void pay(PaymentContext ctx) {
        System.out.println("pay cash to " + ctx.getUserName() + " ¥" + ctx.getMoney());
    }
}
