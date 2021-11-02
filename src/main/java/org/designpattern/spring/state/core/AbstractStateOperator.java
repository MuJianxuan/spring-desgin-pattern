package org.designpattern.spring.state.core;

import org.springframework.util.Assert;

/**
 * 订单
 * @author Rao
 * @Date 2021-10-24
 **/
public abstract class AbstractStateOperator<T,R> implements StateOperate<T,R> {

    /**
     * 1、校验参数
     * 2、执行业务
     * 3、更新状态
     * 4、后置执行
     * @return
     */
    @Override
    public StateResult<R> handle(StateContext<T> stateContext){

        // 校验参数
        this.checkParameters(stateContext);

        // 执行业务事件处理
        this.executeBusinessEventHandle(stateContext);

        //更新状态
        this.updateState(stateContext.getData());

        //后置通知
        return this.afterUpdateState(stateContext);

    }

    /**
     * TODO  添加 并行 校验 设计
     * @param stateContext
     */
    protected void checkParameters(StateContext<T> stateContext) {
        // No operation by default

    }

    /**
     * 执行事件处理
     *   TODO 添加公共业务插件设计  添加策略 实现设计
     *
     * @param stateContext
     */
    protected abstract void executeBusinessEventHandle(StateContext<T> stateContext);

    /**
     * 更新状态
     * @param data
     */
    @Override
    public void updateState(T data) {
        // No operation by default
        Assert.notNull(data,"does not exist");
    }

    /**
     *
     * @param stateContext
     */
    protected StateResult<R> afterUpdateState(StateContext<T> stateContext){
        // No operation by default
        return new StateResult<>();
    }


}
