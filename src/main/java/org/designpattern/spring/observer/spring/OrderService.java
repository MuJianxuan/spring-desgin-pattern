package org.designpattern.spring.observer.spring;

/**
 * @author Rao
 * @Date 2021-11-02
 **/
public interface OrderService {

    /**
     * 创建订单
     */
    void createOrder();

    void notifyMsg();

}
