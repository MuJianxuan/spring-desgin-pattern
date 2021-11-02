package org.designpattern.spring.state.statemachine;

import org.designpattern.spring.state.AvailableState;
import org.designpattern.spring.state.UnavailableState;

/**
 * @author Rao
 * @Date 2021-10-21
 **/
public class StateMachineTest {
    public static void main(String[] args) {

        /**
         * 状态机由状态寄存器和组合逻辑电路构成，能够根据控制信号按照预先设定的状态进行状态转移，
         * 是协调相关信号动作、完成特定操作的控制中心。
         * （状态机是有限状态自动机的简称，是现实事物运行规则抽象而成的一个数学模型。）
         */

        /**
         * 状态模式和状态机模式的区别：
         * 状态模式着重于 业务在当前状态下会执行不同的操作；
         * 而状态机模式更着重于 状态迁移会触发的业务操作；
         */

        StateManager stateManager = new StateManager( new AvailableState());
        stateManager.setState( new UnavailableState());

    }
}
