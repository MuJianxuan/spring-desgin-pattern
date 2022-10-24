package org.designpattern.spring.state.v2demo;

import org.designpattern.spring.state.v2.StateEnum;

/**
 * @author create 2022/7/21 by rao
 */
public enum OrderState implements StateEnum {

    /**
     * 待支付
     */
    waitPay,

    /**
     * 已支付
     */
     paid

    ;

    @Override
    public String state() {
        return this.name();
    }
}
