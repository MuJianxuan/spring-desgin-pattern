package org.designpattern.spring.filterchain.core;


import org.springframework.util.CollectionUtils;

import java.util.List;


/**
 * 扩展一下
 * @author Rao
 * @Date 2022/12/28
 **/
public class IndexFilterChain<T> implements FilterChain<T>  {

    private final List<Filter<T>> filterList;
    private Integer index = 0;

    public IndexFilterChain(List<Filter<T>> filterList) {
        this.filterList = filterList;
    }

    @Override
    public void doFilter(T param) {
        if(! CollectionUtils.isEmpty( filterList) && index != filterList.size()){
            filterList.get( index++).doFilter(param,this);
        }
    }

    /**
     * 可重复执行
     */
    public void repeatExecute(T param){
        this.doFilter(param);
        this.index = 0;
    }

}
