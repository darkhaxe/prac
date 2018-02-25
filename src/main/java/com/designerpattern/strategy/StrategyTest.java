package com.designerpattern.strategy;

import org.junit.Test;

/**
 * @author haze
 * @date created at 2018/2/25 下午2:22
 */
public class StrategyTest {
    @Test
    public void strategy() {
        //create pay strategy
        YuanCash yuanCash = new YuanCash();
        DollarCash dollarCash = new DollarCash();
        //拓展非现金的新形式的付款方式
        Card card = new Card("35621753251");
        PaymentContext ctxYuan = new PaymentContext("jet", 2000, yuanCash);
        PaymentContext ctxDollar = new PaymentContext("spike", 5000, dollarCash);
        PaymentContext accountDollar = new PaymentContext("fei", 1600, card);
        ctxYuan.payNow();
        ctxDollar.payNow();
        accountDollar.payNow();
    }

}
