package org.designpattern.spring.state.order;

import org.designpattern.spring.state.core.*;
import org.designpattern.spring.state.order.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * 状态机
 * 1、管理业务与业务的状态转变
 * @author Rao
 * @Date 2021-10-24
 **/
public class StateMachine{

    // 业务枚举 >>事件 >> 现态 >> 次态
    /**
     * 关于为什么不加上 场景 or 类型  我的考虑是，这个是属于业务范畴的，如果加在映射中，那么我们就将状态模式当成策略模式使用了，
     * 我们应该将当前场景和类型已参数的方式传入 ，然后在执行业务中进行选择策略，这里只需要关注 事件触发状态扭转即可。
     * 不然，加一种类型，这里就要多新建一层Map映射，无法做到多业务兼容处理，把扩展留给开发是最好的设计。
     *
     * 无法兼容 ............ ^&^
     *
     */
    private static Map<String, AbstractStateOperator<Order, Order>> statusOperatorMap = new HashMap<>();

    static {
        String key = StateKeyBuilder.builder()
                .business(BusinessStateMachineEnum.order.name())
                .triggerEvent(OrderStateEventEnum.create_event.name())
                .initState( StateContents.NO_STATUS )
                .nextState(OrderStateEnum.wait_pay.name())
                .build();
        statusOperatorMap.put(key,new CreateOrderStateOperator());
    }
    /**
     * 状态操作者 注册
     */
    public static void registerStateOperator(){
        // to do something

    }


    /**
     * 调用业务
     */
    public static StateResult<Order> handle(StateContext<Order> stateContext){
        return Optional.ofNullable( statusOperatorMap.get(stateContext.getKey())).orElseThrow(() -> new RuntimeException("No implementation found!"))
                // 核心逻辑
                .handle(stateContext);
    }




}
