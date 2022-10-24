package org.designpattern.spring.observer.spring.evrnt;

import org.springframework.context.ApplicationEvent;

/**
 * @author Rao
 * @Date 2022/07/19
 **/
public class BaseEvent<T> extends ApplicationEvent {

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public BaseEvent(Object source) {
        super(source);

    }

    @SuppressWarnings("unchecked")
    public T source(){
        return (T)source;
    }

}
