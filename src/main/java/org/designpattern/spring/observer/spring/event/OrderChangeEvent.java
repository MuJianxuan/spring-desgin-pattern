package org.designpattern.spring.observer.spring.event;

import org.designpattern.spring.state.order.Order;

/**
 * desc: 订单变更事件
 *
 * @author create 2022/7/15 by rao
 */
public class OrderChangeEvent extends BaseApplicationEvent<Order> {
    public OrderChangeEvent(Object source) {
        super(source);
    }
}
