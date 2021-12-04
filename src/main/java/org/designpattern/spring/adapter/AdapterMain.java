package org.designpattern.spring.adapter;

import org.designpattern.spring.adapter.classextends.OrderServiceAdapter;

/**
 * 适配器 模式
 * Target(目标接口)：所需要转换的所期待的接口
 * Adapt(要适配)：需要适配的接口
 * Adapter(适配器)：将原接口适配成目标接口，继承原接口，实现目标接口
 *
 * 适配时 可以非同类！
 *
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
