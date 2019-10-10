package experiment.designerpattern.strategy;

/**
 * @author haze
 * @date created at 2018/2/25 下午2:56
 */
public class Card implements PaymentStrategy {
    /**
     * 需要账号信息
     *
     * @param ctx
     */
    private String account;

    public Card(String account) {
        this.account = account;
    }

    @Override
    public void pay(PaymentContext ctx) {
        System.out.println("use account to pay without cash,pay to " +
                ctx.getUserName() + " $" + ctx.getMoney());
    }
}
