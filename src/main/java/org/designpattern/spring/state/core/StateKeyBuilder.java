package org.designpattern.spring.state.core;

import java.util.Optional;
import java.util.function.Function;

/**
 * 构建 事件 >> 状态 >> 次态
 * @author Rao StateKeyBuilder
 * @Date 2021-10-25
 **/
public class StateKeyBuilder {

    private static final String SYMBOL = ">>";

    /**
     * 业务
     */
    private String business;
    /**
     * 触发事件
     */
    private String triggerEvent;
    /**
     * 初态
     */
    private String initState;
    /**
     * 终态
     */
    private String nextState;

    private StateKeyBuilder(){}

    public static StateKeyBuilder builder(){
        return new StateKeyBuilder();
    }

    public StateKeyBuilder business(String business){
        this.business = business;
        return this;
    }

    public StateKeyBuilder triggerEvent(String event){
        this.triggerEvent = event;
        return this;
    }

    public StateKeyBuilder initState(String initState){
        this.initState = initState;
        return this;
    }

    public StateKeyBuilder nextState(String nextState){
        this.nextState = nextState;
        return this;
    }

    /**
     * 状态key
     * @return
     */
    public String build(){
        Function<String,RuntimeException> exceptionFunction = param -> new RuntimeException(String.format("The %s is invalid!", param));
        String business = Optional.ofNullable(this.business).orElseThrow(() -> exceptionFunction.apply("business"));
        String triggerEvent = Optional.ofNullable(this.triggerEvent).orElseThrow(() -> exceptionFunction.apply("triggerEvent"));
        String initState = Optional.ofNullable(this.initState).orElseThrow(() -> exceptionFunction.apply("initState"));
        String nextState = Optional.ofNullable(this.nextState).orElseThrow(() -> exceptionFunction.apply("nextState"));
        return business + SYMBOL +triggerEvent + SYMBOL + initState + SYMBOL + nextState;
    }


}
