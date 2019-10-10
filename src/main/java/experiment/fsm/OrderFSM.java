package com.fsm;

/**
 *
 */

/**
 * 订单简明状态机
 *
 * @author haze
 * @date created at 2019-03-08 16:18
 */
public class OrderFSM {
    private SpaceOrderFSMState fsmSpaceState = SpaceOrderFSMState.NOPAY_NOORDER;

    private OrderFSMContextData contextData;

    /**
     * 测试数据
     */
    public static void main(String[] args) {
        OrderFSM fsm = OrderFSM.init(
                new OrderFSMContextData(true,
                        true,
                        true,
                        true
                )).fire(FSMEvent.ORDER_CREATE);
    }

    public static OrderFSM init(OrderFSMContextData contextData) {
        return new OrderFSM(contextData);
    }

    public OrderFSM(OrderFSMContextData contextData) {
        this.contextData = contextData;
    }

    public OrderFSM fire(FSMEvent event) {
        OrderFSM fsm = null;

        switch (event) {
            case ORDER_CREATE:
                fsm = orderCreate(contextData);
                break;
//            ...略...
            default:
                throw new RuntimeException("订单FSM不支持的事件类型");
        }
        return fsm;
    }

    public SpaceOrderFSMState getFsmSpaceState() {
        return fsmSpaceState;
    }


    //以订单创建为例
    private OrderFSM orderCreate(OrderFSMContextData contextData) {
        if (fsmSpaceState != SpaceOrderFSMState.NOPAY_NOORDER) {
            throw new RuntimeException("FSM:当前状态不允许 ORDER_CREATE 事件");
        }
        //分销
        if (contextData.isDistribute()) {
            if (contextData.isPayed()) {
                this.fsmSpaceState = contextData.isSelfSupport() ? SpaceOrderFSMState.PAYED_NOCONFIRM : SpaceOrderFSMState.PAYED_NOORDER;
            } else {
                this.fsmSpaceState = contextData.isSelfSupport() ? SpaceOrderFSMState.NOPAY_NOCONFIRM : SpaceOrderFSMState.NOPAY_NOORDER;
            }
        } else {
            //非分销
            this.fsmSpaceState = contextData.isSelfSupport() ? SpaceOrderFSMState.NOPAY_NOCONFIRM : SpaceOrderFSMState.NOPAY_NOORDER;
        }
        return this;
    }

}

