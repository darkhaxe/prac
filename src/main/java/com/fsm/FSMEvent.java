package com.fsm;

import lombok.Getter;

/**
 * @author haze
 * @date created at 2019-03-20 14:53
 */
public enum FSMEvent {
    /**
     * //订单创建
     */
    ORDER_CREATE,
    BUSINOTIFY_ORDERFAILED;//业务结果通知，下单失败
//        ...略...
}
