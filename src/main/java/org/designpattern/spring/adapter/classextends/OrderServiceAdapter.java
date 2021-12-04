package org.designpattern.spring.adapter.classextends;

import org.designpattern.spring.adapter.OrderService;
import org.designpattern.spring.adapter.OrderServiceImpl;

/**
 * Adapter 适配者
 * 适配 逻辑
 * @author Rao
 * @Date 2021-11-02
 **/
public class OrderServiceAdapter extends OrderServiceImpl {

    @Override
    public String createOrder() {
        return super.createOrder() + "classextends adapter";
    }
}
