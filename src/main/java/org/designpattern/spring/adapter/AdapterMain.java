package org.designpattern.spring.adapter;

import org.designpattern.spring.adapter.classextends.OrderServiceAdapter;

/**
 * @author Rao
 * @Date 2021-11-02
 **/
public class AdapterMain {
    public static void main(String[] args) {

        OrderService orderService = new OrderServiceImpl();
        System.out.println(orderService.createOrder());

        OrderService orderServiceAdapter = new OrderServiceAdapter();
        System.out.println(orderServiceAdapter.createOrder());

        OrderService orderServiceAdapter1 = new org.designpattern.spring.adapter.combination.OrderServiceAdapter(orderService);
        System.out.println(orderServiceAdapter1.createOrder());


    }
}
