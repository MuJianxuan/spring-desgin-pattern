package org.designpattern.spring.state.simplestate;

/**
 * 抽象的状态容器
 * @author Rao
 * @Date 2022/10/24
 **/
public abstract class AbstractStateContext<P,R> implements State<P,R> {

    private State<P,R> state;

    public void setState(State<P, R> state) {
        this.state = state;
    }

    @Override
    public R doAction(P param) {
        return state.doAction(param);
    }

    @Override
    public void execute(P param) {
        state.execute(param);
    }
}
