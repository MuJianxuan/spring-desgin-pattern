package org.designpattern.spring.responsibilitychain.core;

/**
 * 链
 * @author Rao
 * @Date 2021-11-01
 **/
public interface Chain<T> {

    /**
     * 执行
     * @param param
     * @return
     */
    void execute(T param);

}
