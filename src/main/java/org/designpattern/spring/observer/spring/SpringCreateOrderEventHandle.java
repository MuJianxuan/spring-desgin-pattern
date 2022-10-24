package org.designpattern.spring.observer.spring;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.designpattern.spring.observer.spring.event.CreateOrderEvent;
import org.designpattern.spring.observer.spring.event.OrderChangeEvent;
import org.designpattern.spring.state.order.Order;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.context.event.EventListenerMethodProcessor;
import org.springframework.stereotype.Component;

/**
 *
 * 解析 看 {@link EventListenerMethodProcessor}
 * @author Rao
 * @Date 2021-11-02
 **/
@Slf4j
@Component
public class SpringCreateOrderEventHandle implements ApplicationListener<CreateOrderEvent> {

    /**
     *  在注解注释有一句描述
     *    ： 方法最多只能有一个参数
     *
     *  这里有一个需要特别注意的地方
     *     由于 解析使用的是 {@link SmartInitializingSingleton} ，是在所有单例bean（非懒，非那啥）完全初始化完之后才会 调用执行。
     *     其本质逻辑是 将method调用对象和参数封装成一个 applicationListener 并添加到 观察者中，（在spring中 applicationContext 是持有这个功能的）
     *     因此，在 某些生命周期方法中调用相关初始化时，会导致该方法不会触发。
     * @param event
     */
    @EventListener(value= CreateOrderEvent.class)
    public void handleCreateOrderEvent1(CreateOrderEvent event){
        OrderService orderService = (OrderService) event.getSource();

        orderService.notifyMsg();
        System.out.println( "handleCreateOrderEvent1:" + event );

    }

    @EventListener(value = OrderChangeEvent.class)
    public void handleOrderChangeEvent(OrderChangeEvent orderChangeEvent){
        Order source = orderChangeEvent.source();
        log.info("接收到可变的订单消息:{}", JSON.toJSONString( source ));
    }

    /**
     * 有触发
     * @param event
     */
    @Override
    public void onApplicationEvent(CreateOrderEvent event) {
        OrderService orderService = (OrderService) event.getSource();

        orderService.notifyMsg();
        System.out.println( "onApplicationEvent:" + event );
    }

//    @EventListener(value = CreateOrderEvent.class)
//    public void handleCreateOrderEvent2(CreateOrderEvent createOrderEvent){
//
//        System.out.println( "handleCreateOrderEvent2:" +createOrderEvent );
//
//    }

}
