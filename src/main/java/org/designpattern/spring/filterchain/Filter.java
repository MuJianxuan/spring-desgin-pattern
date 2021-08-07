package org.designpattern.spring.filterchain;

/**
 * @author Rao
 * @Date 2021/8/1
 **/
public interface Filter {

    void doFilter(FilterChain filterChain);

}
