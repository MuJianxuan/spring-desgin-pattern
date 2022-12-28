package org.designpattern.spring.filterchain.filterchain;

import org.designpattern.spring.filterchain.Filter;
import org.designpattern.spring.filterchain.FilterChain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

/**
 * @author Rao
 * @Date 2021/8/2
 **/
public class SimpleFilterChain implements FilterChain {

    // 迭代器只能执行一次
    private final Iterator<? extends Filter> chain;

    public SimpleFilterChain(Iterator<? extends Filter> chain) {
        this.chain = chain;
    }

    @Override
    public void doFilter(){
        if(chain != null && chain.hasNext()){
            chain.next().doFilter(this);
        }
    }


}
