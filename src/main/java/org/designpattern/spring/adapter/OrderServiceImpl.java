package org.designpattern.spring.adapter;

/**
 * Adapt
 * @author Rao
 * @Date 2021-11-02
 **/
public class OrderServiceImpl implements OrderService {

    @Override
    public String createOrder() {
        return "order1";
    }
}
