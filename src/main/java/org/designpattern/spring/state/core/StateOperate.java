package org.designpattern.spring.state.core;

/**
 * 操作状态
 *
 * @author Rao
 * @Date 2021-10-23
 **/
public interface StateOperate<T,R> {

    StateResult<R> handle(StateContext<T> stateContext);

    // TODO 移除 updateSate 方法， 添加 仅校验和更新的入口，以更具体的接口定义暴露方法。

    /**
     * 提供仅更新对象的状态入口
     */
    void updateState(T data);

    /**
     * 操作key
     */
    String operateKey();


}
