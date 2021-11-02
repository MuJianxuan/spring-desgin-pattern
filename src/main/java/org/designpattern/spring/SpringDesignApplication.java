package org.designpattern.spring;

import com.alibaba.fastjson.JSON;
import org.designpattern.spring.observer.spring.OrderService;
import org.designpattern.spring.responsibilitychain.core.ResponsibilityChain;
import org.designpattern.spring.state.core.*;
import org.designpattern.spring.state.order.*;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.annotation.Resource;

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

    @Resource(name = "orderStateMachine")
    private AbstractStateMachine<Order, Order> stateMachine;

    @Resource(name = "orderResponsibilityChain")
    private ResponsibilityChain<Param> orderResponsibilityChain;

    @Autowired
    private OrderService orderService;

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringDesignApplication.class, args);

        OrderService orderService = applicationContext.getBean(OrderService.class);
        orderService.createOrder();

    }


    @Override
    public void afterPropertiesSet() throws Exception {
        String key = StateKeyBuilder.builder()
                .business(BusinessStateMachineEnum.order.name())
                .triggerEvent(OrderStateEventEnum.create_event.name())
                .initState( StateContents.NO_STATUS )
                .nextState(OrderStateEnum.wait_pay.name())
                .build();

        System.out.println(key);

        StateContext<Order> stateContext = new StateContext<>();
        stateContext.setKey( key);
        StateResult<Order> orderResultStateResult = stateMachine.execute(stateContext);
        System.out.println( "结果：" + JSON.toJSONString( orderResultStateResult));


        orderResponsibilityChain.execute( new Param());

        orderService.createOrder();

    }
}
