package org.designpattern.spring.state.v2demo;

import org.designpattern.spring.state.v2.DrivenEvent;
import org.designpattern.spring.state.v2.StateEnum;

/**
 * 订单状态驱动事件
 * @author create 2022/7/21 by rao
 */
public enum OrderStateDrivenEvent implements DrivenEvent {

    /**
     * 支付事件
     */
    pay(){
        @Override
        public StateEnum initialState() {
            return OrderState.waitPay;
        }

        @Override
        public StateEnum finalState() {
            return OrderState.paid;
        }
    },

    ;


    @Override
    public String event() {
        return this.name();
    }
}
