package org.designpattern.spring.observer;

/**
 * 观察订阅模式：
 * 1、观察者负载观察事件发生
 * 2、事件发布者负责发布事件
 * 3、订阅者接收观察者推送过来的事件消息
 * 4、事件对象负责传递信息数据。
 *
 *  {@link org.springframework.context.event.EventListenerMethodProcessor}
 *
 * @author Rao
 * @Date 2021-11-02
 **/
public class ObserverMain {
    public static void main(String[] args) {

        /**
         * 订阅观察者设计模式 主要用于 一个事件会触发多条无返回的执行操作时，有利于扩展；
         * 考虑场景有：异步/同步执行，异步不同线程池池，可以升级成 基于注解解析Method方法级别的调用。
         * 在Shiro中有设计 一套 订阅发布者设计模式，基于注解来实现  相关订阅和通知，与Spring的设计类似。
         */





    }
}
