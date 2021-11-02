package org.designpattern.spring.observer;

import org.springframework.context.ApplicationEvent;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Rao
 * @Date 2021-11-02
 **/
public class Observer implements Observe {

    /**
     * 初始化
     */
    private final Set<Subscribe> subscribeSet;

    public Observer() {
        subscribeSet = new HashSet<>();
    }

    @Override
    public void registerSubscriber(Subscribe subscribe) {
        subscribeSet.add( subscribe);
    }

    @Override
    public void removeSubscriber(Subscribe subscribe) {
        subscribeSet.remove( subscribe);
    }

    @Override
    public void notifyAllSubscriber(ApplicationEvent event) {
        subscribeSet.forEach(subscribe -> subscribe.notifyExecute(event));

    }

    @Override
    public void publishEvent(ApplicationEvent event) {

        this.notifyAllSubscriber( event);

    }
}
