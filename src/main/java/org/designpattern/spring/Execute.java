package org.designpattern.spring;

/**
 * @author Rao
 * @Date 2021-11-01
 **/
public interface Execute<T> {

    /**
     * 执行
     * @param param
     */
    void execute(T param);

}
