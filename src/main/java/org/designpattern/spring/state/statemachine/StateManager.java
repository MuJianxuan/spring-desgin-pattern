package org.designpattern.spring.state.statemachine;

import org.designpattern.spring.state.ChannelState;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * 一定数量的事件导致 当前状态的变更；
 * 当前状态变更成另外一个 状态的时候 执行消费业务
 * 当别人获取到当前的全局状态后，又可以处理不同的业务流程。
 *
 * @author Rao
 * @Date 2021-10-21
 **/
public class StateManager {

    /**
     * 当前状态
     */
    private ChannelState currentSate;

    public StateManager(ChannelState currentSate) {
        this.currentSate = currentSate;
    }

    // ? 写死了返回信息
    private static Map<String, Consumer<String>> stateBehaviorContext = new HashMap<>();
    static {
        stateBehaviorContext.put(State.availableState +"->"+ State.unavailableState,state -> {
            System.out.println("who are you!");
            System.out.println(state);
        });
    }

    public void setState(ChannelState willState){
        Optional.ofNullable( stateBehaviorContext.get(currentSate.markId()+"->"+willState.markId())).ifPresent(consumer -> consumer.accept("i will sleep!"));
        this.currentSate = willState;
    }

}
