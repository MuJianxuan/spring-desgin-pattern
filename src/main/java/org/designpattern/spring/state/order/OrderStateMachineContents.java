package org.designpattern.spring.state.order;

/**
 * 订单状态机 常量 替代 枚举 ；
 * 枚举有些地方无法使用
 * @author Rao
 * @Date 2021-10-25
 **/
public interface OrderStateMachineContents {

    // -------------状态枚举
    /**
     * 待支付
     */
    String WAIT_PAY = "wait_pay";

    /**
     * 待收货
     */
    String WAIT_RECEIPT = "wait_receipt";


    // ------------事件枚举
    /**
     * 下单
     */
    String CREATE_EVENT = "create_event";
    /**
     * 支付
     */
    String PAY_EVENT = "pay_event";




}
