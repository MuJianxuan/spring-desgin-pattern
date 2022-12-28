package org.designpattern.spring.filterchain.filterchain;

import org.designpattern.spring.filterchain.Filter;
import org.designpattern.spring.filterchain.FilterChain;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * 过滤链对象
 * @author Rao
 * @Date 2021/8/1
 **/
public class IndexFilterChain implements FilterChain {

    private final List<Filter> filterList;
    private int index = 0;

    public IndexFilterChain(List<Filter> filterList) {
        this.filterList = filterList;
    }

    @Override
    public void doFilter( ){
        if(! CollectionUtils.isEmpty( filterList) && index != filterList.size()){
            filterList.get( index++).doFilter(this);
            index = 0;
        }
    }

}
