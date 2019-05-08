package com.fsm;

/**
 * @author haze
 * @date created at 2019-03-20 14:54
 */
public enum SpaceOrderFSMState {
    /**
     *
     */
    PAYED_NOCONFIRM(1000, "支付未确认"),
    NOPAY_NOORDER(1020, "待支付待下单"),
    PAYED_NOORDER(1020, "支付待下单"),
    NOPAY_ORDERFAILED(1023, "待支付下单失败"),
    NOPAY_NOCONFIRM(1010, "待支付待确认");
//        ...略...

    SpaceOrderFSMState(int i, String 待支付待下单) {

    }
}
