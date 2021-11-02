package org.designpattern.spring.state.core;

/**
 * 状态上下文
 *   重构：
 *      建造者方式 处理 ，需要传入不同参数，以及包含状态的对象。
 *      利用方法规定 存储的对象是何key
 * @author Rao
 * @Date 2021-10-23
 **/
public class StateContext<T> {

    /**
     * 操作key
     */
    private String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    /**
     * 原始数据
     */
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
