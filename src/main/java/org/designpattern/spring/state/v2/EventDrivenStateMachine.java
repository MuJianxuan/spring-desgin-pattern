package org.designpattern.spring.state.v2;

import java.util.Map;

/**
 * 泛型表示不同业务 TR 兄弟
 *
 * desc: 事件驱动状态机
 *  // 通过配置注入后，自动通过bean定义注入到容器里
 *  // 开发人员拿来就用
 *
 *   要注入到容器吗
 *     不注入到容器
 *
 * @author create 2022/7/16 by rao
 */
public class EventDrivenStateMachine<T extends StateMachineId> extends StateContext<T> {

    /**
     * 持久化助手
     */
    private final AbstractStateAssistant<T> stateAssistant;

    /**
     * 事件行为驱动池
      */
    private final Map<DrivenEvent,AbstractEventBehaviorHandler<T>> eventBehaviorHandlerPool;

    public EventDrivenStateMachine(AbstractStateAssistant<T> stateAssistant, Map<DrivenEvent,
                                   AbstractEventBehaviorHandler<T>> eventBehaviorHandlerPool) {
        this.stateAssistant = stateAssistant;
        this.eventBehaviorHandlerPool = eventBehaviorHandlerPool;
    }

    /**
     * 驱动方法
     * @param drivenEvent
     * @return
     */
    public void drive(DrivenEvent drivenEvent){

        StateEnum stateEnum = stateAssistant.read(this);
        if( ! drivenEvent.initialState().state().equals( stateEnum.state() )){
            //当前状态已过期
            return;
        }
        // 持久化失败立即处理
        stateAssistant.write(this);

    }

}
