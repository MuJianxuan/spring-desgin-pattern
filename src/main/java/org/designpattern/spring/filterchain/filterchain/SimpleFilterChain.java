package org.designpattern.spring.filterchain.filterchain;

import org.designpattern.spring.filterchain.Filter;
import org.designpattern.spring.filterchain.FilterChain;

import java.util.Iterator;

/**
 * @author Rao
 * @Date 2021/8/2
 **/
public class SimpleFilterChain implements FilterChain {

    private final Iterator<? extends Filter> chain;

    public SimpleFilterChain(Iterator<? extends Filter> chain) {
        this.chain = chain;
    }

    @Override
    public void doFilter(){

        if( chain.hasNext()){
            chain.next().doFilter(this);
        }

    }


}
