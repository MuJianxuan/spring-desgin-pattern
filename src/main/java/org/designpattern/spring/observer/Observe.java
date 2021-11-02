package org.designpattern.spring.observer;

import org.springframework.context.ApplicationEvent;

/**
 * 观察者
 * 1、注册订阅者
 * 2、推送订阅消息
 * 3、移除订阅着
 * 4、发布事件
 * @author Rao
 * @Date 2021-11-02
 **/
public interface Observe {

    /**
     * 注册
     */
    void registerSubscriber(Subscribe subscribe);

    /**
     *
     */
    void removeSubscriber(Subscribe subscribe);

    /**
     * 通知所有的
     */
    void notifyAllSubscriber(ApplicationEvent event);

    /**
     * 发布事件
     */
    void publishEvent(ApplicationEvent event);

}
