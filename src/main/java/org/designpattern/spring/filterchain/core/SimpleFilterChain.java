package org.designpattern.spring.filterchain.core;

import org.springframework.util.CollectionUtils;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

/**
 * @author Rao
 * @Date 2021-11-01
 **/
public class SimpleFilterChain<T> implements FilterChain<T> {

    /**
     * 链
     */
    private final Iterator<Filter<T>> filterChain;

    public SimpleFilterChain(List<Filter<T>> filterList) {
        this.filterChain = filterList.iterator();
    }

    @Override
    public void doFilter(T param) {
        Iterator<Filter<T>> iterator = Optional.ofNullable(filterChain).orElseThrow(() -> new RuntimeException("The filter chain was not found!"));
        while ( iterator.hasNext()){
            iterator.next().doFilter( param,this);
        }
    }
}
