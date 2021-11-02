package org.designpattern.spring.state.order;

import org.designpattern.spring.state.core.*;

import java.util.HashMap;

/**
 * @author Rao
 * @Date 2021-10-25
 **/
@StateOperator(business = "order",triggerEvent = "create_event",initState = StateContents.NO_STATUS,nextState = "wait_receipt")
public class CreateOrderStateOperator extends AbstractStateOperator<Order,Order> {

    /**
     * 核心逻辑
     * @param stateContext
     */
    @Override
    protected void executeBusinessEventHandle(StateContext<Order> stateContext) {
        // 这里可以使用策略模式 再加以扩展
        // 比如是 不同场景 下创建订单， 又或者是 不同类型 在设计上看如何兼容。
        Order order = new Order();
        order.setId( 1L);
        order.setOrderStatus(0);
        order.setUserId(1L);
        order.setPrice(10);

        // 创建订单成功
        stateContext.setData(order);
    }

    @Override
    protected StateResult<Order> afterUpdateState(StateContext<Order> stateContext) {
        //模拟第三方创建预防单  调用第三方创建预付单

        // 入参与转惨
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("url","http://www.baidu.com");

        return new StateResult<>(stateContext.getData());
    }

    @Override
    public String operateKey() {
        return StateKeyBuilder.builder()
                .business(BusinessStateMachineEnum.order.name())
                .triggerEvent(OrderStateEventEnum.create_event.name())
                .initState( StateContents.NO_STATUS )
                .nextState(OrderStateEnum.wait_pay.name())
                .build();
    }
}
