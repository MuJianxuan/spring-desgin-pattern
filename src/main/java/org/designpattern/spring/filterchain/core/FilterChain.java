package org.designpattern.spring.filterchain.core;

/**
 * @author Rao
 * @Date 2021/8/2
 **/
public interface FilterChain<T> {
    void doFilter(T param);

}
