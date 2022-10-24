package org.designpattern.spring.observer.spring.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author Rao
 * @Date 2021-11-02
 **/
public class CreateOrderEvent extends ApplicationEvent {
    public CreateOrderEvent(Object source) {
        super(source);
    }
}
