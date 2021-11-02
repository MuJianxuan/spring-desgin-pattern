package org.designpattern.spring.state.statemachine;

/**
 * @author Rao
 * @Date 2021-10-21
 **/
public interface State {

    int availableState = 1;
    int unavailableState = 2;


    int markId();

}
