package org.designpattern.spring.state;

import org.designpattern.spring.state.statemachine.State;

/**
 * @author Rao
 * @Date 2021-10-21
 **/
public class AvailableState implements ChannelState {

    // 委托给例外一个家伙执行


    @Override
    public void createPrepaidOrder() {


        System.out.println("oh ,you can execute!");

        // .........

    }

    @Override
    public int markId() {
        return State.availableState;
    }
}
