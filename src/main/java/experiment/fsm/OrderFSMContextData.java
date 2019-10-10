package com.fsm;

import lombok.Getter;

/**
 * OrderFSMContextData存储状态机的上下文信息
 *
 *     用于具体状态变迁时的逻辑判断
 * @author haze
 * @date created at 2019-03-20 14:52
 */
@Getter
public class OrderFSMContextData {
    private boolean isPayed;
    private boolean isDistribute;
    private boolean isSelfSupport;
    private boolean isInquiry;

    /**
     *
     * @param isPayed 是否已经支付成功
     * @param isDistribute 是否为分销
     * @param isSelfSupport 是否自营
     * @param isInquiry 是否询单
     */
    public OrderFSMContextData(boolean isPayed, boolean isDistribute,
                               boolean isSelfSupport, boolean isInquiry) {
        this.isPayed = isPayed;
        this.isDistribute = isDistribute;
        this.isSelfSupport = isSelfSupport;
        this.isInquiry = isInquiry;
    }

//    public boolean isPayed() {
//        return isPayed;
//    }
//
//    public boolean isDistribute() {
//        return isDistribute;
//    }
//
//    public boolean isSelfSupport() {
//        return isSelfSupport;
//    }
//
//    public boolean isInquiry() {
//        return isInquiry;
//    }
}
