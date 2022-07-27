package org.designpattern.spring;

import org.designpattern.spring.state.order.Order;
import org.designpattern.spring.state.v2.EventDrivenStateMachine;
import org.designpattern.spring.state.v2.EventDrivenStateMachineManager;
import org.designpattern.spring.state.v2demo.OrderStateDrivenEvent;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * TODO
 * 已完成初步设计
 * 1、完成相关设计模式的 设计
 * 2、完成分业务扩展。1、策略模式下 同 T,R 情况下的业务区分未做。
 * 3、
 * @author Rao
 * @Date 2021-10-26
 **/
@SpringBootApplication
public class SpringDesignApplication implements InitializingBean {



    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringDesignApplication.class, args);

        EventDrivenStateMachineManager eventDrivenStateMachineManager = applicationContext.getBean(EventDrivenStateMachineManager.class);
        EventDrivenStateMachine<Order> orderEventDrivenStateMachine = eventDrivenStateMachineManager.<Order>create();

        Order order = new Order();
        order.setId( 10L);

        orderEventDrivenStateMachine.drive(OrderStateDrivenEvent.pay,order);

    }


    @Override
    public void afterPropertiesSet() throws Exception {
        //String key = StateKeyBuilder.builder()
        //        .business(BusinessStateMachineEnum.order.name())
        //        .triggerEvent(OrderStateEventEnum.create_event.name())
        //        .initState( StateContents.NO_STATUS )
        //        .nextState(OrderStateEnum.wait_pay.name())
        //        .build();
        //
        //System.out.println(key);

        //StateContext<Order> stateContext = new StateContext<>();
        //stateContext.setKey( key);
        //StateResult<Order> orderResultStateResult = stateMachine.execute(stateContext);
        //System.out.println( "结果：" + JSON.toJSONString( orderResultStateResult));


        //orderResponsibilityChain.execute( new Param());

        //orderService.createOrder();

    }
}
