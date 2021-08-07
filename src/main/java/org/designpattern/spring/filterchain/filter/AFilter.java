package org.designpattern.spring.filterchain.filter;

import org.designpattern.spring.filterchain.Filter;
import org.designpattern.spring.filterchain.FilterChain;

/**
 * @author Rao
 * @Date 2021/8/1
 **/
public class AFilter implements Filter {
    @Override
    public void doFilter(FilterChain filterChain) {
        System.out.println("A..........");
        filterChain.doFilter();
    }
}
