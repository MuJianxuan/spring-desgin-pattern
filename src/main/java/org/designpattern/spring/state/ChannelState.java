package org.designpattern.spring.state;

import org.designpattern.spring.state.statemachine.State;

/**
 * @author Rao
 * @Date 2021-10-20
 **/
public interface ChannelState extends State {

    /**
     * 创建预付单
     */
    void createPrepaidOrder();

}
