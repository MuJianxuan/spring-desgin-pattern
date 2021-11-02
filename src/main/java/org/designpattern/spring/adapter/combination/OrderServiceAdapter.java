package org.designpattern.spring.adapter.combination;

import org.designpattern.spring.adapter.OrderService;

/**
 * @author Rao
 * @Date 2021-11-02
 **/
public class OrderServiceAdapter implements OrderService {

    private OrderService orderService;

    public OrderServiceAdapter(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public String createOrder() {
        return orderService.createOrder() + " : combination adapter";
    }
}
