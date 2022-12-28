package org.designpattern.spring.observer.spring.evrnt;

import org.designpattern.spring.state.order.Order;

/**
 * @author Rao
 * @Date 2022/07/19
 **/
public class OrderEvent extends BaseEvent<Order> {
    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public OrderEvent(Object source) {
        super(source);
    }
}
