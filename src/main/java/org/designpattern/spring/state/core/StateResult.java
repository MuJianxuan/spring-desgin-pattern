package org.designpattern.spring.state.core;

/**
 * @author Rao
 * @Date 2021-10-25
 **/
public class StateResult<R> {

    private R result;

    public StateResult() {
    }

    public StateResult(R result) {
        this.result = result;
    }

    public R getResult() {
        return result;
    }

    public void setResult(R result) {
        this.result = result;
    }
}
