package org.designpattern.spring.strategy.core;

/**
 * 策略池
 * @author Rao
 * @Date 2021-11-01
 **/
public interface Strategy<T,R> {

    /**
     * 执行
     * @param param
     * @return
     */
    R execute(T param);

    /**
     * 策略Key
     * @return
     */
    String strategyKey();

}
