package org.designpattern.spring.state.v2demo;

import lombok.extern.slf4j.Slf4j;
import org.designpattern.spring.state.order.Order;
import org.designpattern.spring.state.v2.AbstractEventBehaviorHandler;
import org.designpattern.spring.state.v2.DrivenEvent;
import org.designpattern.spring.state.v2.StateContext;
import org.springframework.stereotype.Component;

/**
 * @author create 2022/7/21 by rao
 */
@Slf4j
@Component
public class Test1EventHandler extends AbstractEventBehaviorHandler<Order> {
    @Override
    protected void triggerBehaviorHandle(StateContext<Order> stateContext) {
        log.info("Test1EventHandler >> 执行业务处理......");
    }

    @Override
    protected DrivenEvent drivenEvent() {
        return OrderStateDrivenEvent.pay;
    }
}
