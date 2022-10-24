package org.designpattern.spring.observer.spring;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.designpattern.spring.observer.spring.evrnt.BaseEvent;
import org.designpattern.spring.state.order.Order;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 *  监听人
 * @author Rao
 * @Date 2022/07/19
 **/
@Slf4j
@Component
public class OrderListener implements ApplicationListener<BaseEvent<Order>> {
    @Override
    public void onApplicationEvent(BaseEvent<Order> event) {

        log.info("OrderListener  evert:  {}", JSON.toJSONString( event));

    }
}
