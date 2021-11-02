package org.designpattern.spring.state.core;

/**
 * 目前有警告问题
 *
 *    似乎行不通
 * @author Rao
 * @Date 2021-10-26
 **/
@Deprecated
@SuppressWarnings("")
public interface StateMachine {

    @SuppressWarnings("")
    void addStateOperator(String key,AbstractStateOperator stateOperator);

}
