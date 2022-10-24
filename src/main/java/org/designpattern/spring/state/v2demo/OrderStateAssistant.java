package org.designpattern.spring.state.v2demo;

import lombok.extern.slf4j.Slf4j;
import org.designpattern.spring.state.order.Order;
import org.designpattern.spring.state.v2.AbstractStateAssistant;
import org.designpattern.spring.state.v2.StateContext;
import org.designpattern.spring.state.v2.StateEnum;
import org.designpattern.spring.state.v2.StateMachineId;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author create 2022/7/21 by rao
 */
@Slf4j
@Component
public class OrderStateAssistant extends AbstractStateAssistant<Order> {
    @Override
    protected StateEnum read(StateContext<Order> stateContext) {
        log.info("读取状态.....");
        StateMachineId stateMachineId = stateContext.getStateMachineId();
        Serializable id = stateMachineId.stateMachineId();
        return OrderState.waitPay;
    }

    @Override
    protected Boolean write(StateContext<Order> stateContext) {
        log.info("持久化状态...." + stateContext.getFinalState().state());
        return true;
    }
}
