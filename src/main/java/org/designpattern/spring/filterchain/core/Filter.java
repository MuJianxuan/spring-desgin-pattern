package org.designpattern.spring.filterchain.core;


/**
 * @author Rao
 * @Date 2021-11-01
 **/
@FunctionalInterface
public interface Filter<T> {

    void doFilter(T param, FilterChain<T> filterChain);

}
