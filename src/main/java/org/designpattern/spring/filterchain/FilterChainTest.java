package org.designpattern.spring.filterchain;

import org.designpattern.spring.filterchain.filterchain.IndexFilterChain;
import org.designpattern.spring.filterchain.filter.AFilter;
import org.designpattern.spring.filterchain.filter.BFilter;
import org.designpattern.spring.filterchain.filterchain.SimpleFilterChain;

import java.util.Arrays;

/**
 * @author Rao
 * @Date 2021/8/1
 **/
public class FilterChainTest {
    public static void main(String[] args) {
        AFilter aFilter = new AFilter();
        BFilter bFilter = new BFilter();

        IndexFilterChain indexFilterChain = new IndexFilterChain( Arrays.asList(aFilter, bFilter));
        indexFilterChain.doFilter();

        SimpleFilterChain simpleFilterChain = new SimpleFilterChain(Arrays.asList(aFilter, bFilter).iterator());
        simpleFilterChain.doFilter();


    }
}
