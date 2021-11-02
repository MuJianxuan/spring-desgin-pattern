package org.designpattern.spring.state;

import org.designpattern.spring.state.statemachine.State;

/**
 * 不可用
 * @author Rao
 * @Date 2021-10-21
 **/
public class UnavailableState implements ChannelState {

    @Override
    public void createPrepaidOrder() {

        // 拒绝策略
        System.out.println("oh, this is error,Try again later!");

    }

    @Override
    public int markId() {
        return State.unavailableState;
    }
}
