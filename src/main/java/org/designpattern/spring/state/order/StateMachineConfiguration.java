package org.designpattern.spring.state.order;

import org.designpattern.spring.state.core.AbstractStateMachine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Rao
 * @Date 2021-10-26
 **/
@Configuration
public class StateMachineConfiguration {

    @Bean("orderStateMachine")
    public AbstractStateMachine<Order,Order> orderStateMachine(){
        return new AbstractStateMachine<Order, Order>() {};
    }

}
