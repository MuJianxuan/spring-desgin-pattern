package org.designpattern.spring.state.order;

/**
 * 业务 状态机枚举
 * @author Rao
 * @Date 2021-10-24
 **/
public enum BusinessStateMachineEnum {
    /**
     * 订单
     */
    order,

    /**
     * 文章
     */
    article,
    ;

    public static String getName(){
        return "order";
    }


}
