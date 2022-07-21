package org.designpattern.spring.observer.spring.event;

import org.springframework.context.ApplicationEvent;

/**
 * desc: 抽象
 *
 * @author create 2022/7/15 by rao
 */
public abstract class BaseApplicationEvent<T> extends ApplicationEvent {
    public BaseApplicationEvent(Object source) {
        super(source);
    }

    @SuppressWarnings("unchecked")
    public T source(){
        return (T) source;
    }

}
