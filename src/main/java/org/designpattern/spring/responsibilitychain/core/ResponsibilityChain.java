package org.designpattern.spring.responsibilitychain.core;

/**
 * @author Rao
 * @Date 2021-11-01
 **/
public interface ResponsibilityChain<T> {

    /**
     * 执行
     * @param param
     * @return
     */
    void execute(T param);

}
