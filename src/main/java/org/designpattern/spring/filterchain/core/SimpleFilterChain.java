package org.designpattern.spring.filterchain.core;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

/**
 * @author Rao
 * @Date 2021-11-01
 **/
public abstract class SimpleFilterChain<T> implements FilterChain<T>, InitializingBean {

    @Resource
    private List<Filter<T>> filterList;

    private Iterator<Filter<T>> filterChain;

    @Override
    public void doFilter(T param) {
        Iterator<Filter<T>> iterator = Optional.ofNullable(filterChain).orElseThrow(() -> new RuntimeException("The filter chain was not found!"));
        while ( iterator.hasNext()){
            iterator.next().doFilter( param,this);
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {

        if(! CollectionUtils.isEmpty( filterList)){
            filterChain = filterList.iterator();
        }

    }
}
