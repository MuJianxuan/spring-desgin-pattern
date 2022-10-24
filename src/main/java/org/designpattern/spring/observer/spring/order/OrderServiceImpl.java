package org.designpattern.spring.observer.spring.order;

import org.designpattern.spring.observer.spring.OrderService;
import org.designpattern.spring.observer.spring.event.CreateOrderEvent;
import org.designpattern.spring.observer.spring.event.OrderChangeEvent;
import org.designpattern.spring.state.order.Order;
import org.designpattern.spring.observer.spring.evrnt.BaseEvent;
import org.designpattern.spring.observer.spring.evrnt.CreateOrderEvent;
import org.designpattern.spring.observer.spring.evrnt.OrderEvent;
import org.designpattern.spring.state.order.Order;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Rao
 * @Date 2021-11-02
 **/
@Service
public class OrderServiceImpl implements OrderService {

    /**
     * 注入时间发布者
     */
    @Resource
    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void createOrder() {

        System.out.println("orderService create order!");

//        applicationEventPublisher.publishEvent( new CreateOrderEvent(this));
        Order order = new Order();
        order.setId(1L);
//        applicationEventPublisher.publishEvent( new BaseEvent<>(order));
        applicationEventPublisher.publishEvent( new OrderEvent(order));

        applicationEventPublisher.publishEvent(new OrderChangeEvent(new Order().setId(1L)));

        // 为什么不直接调用呢？
//        this.notifyMsg();
    }

    /**
     * 执行方法
     *
     *  我写此方法的目的不是说 一定要这么调用，而是 提供这么一种想法。
     *   1、会发现更麻烦了，干嘛不直接 调用此方法，
     */
    @Override
    public void notifyMsg(){

        System.out.println("notifyMsg ..........");

    }

}
