package org.designpattern.spring.strategy.core;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author Rao
 * @Date 2021-11-01
 **/
public abstract class AbstractStrategyPool<T,R> implements InitializingBean {

    @Resource
    private List<Strategy<T,R>> strategyList;

    private Map<String, Strategy<T, R>> strategyMap;

    public R execute(String strategyKey, T param){
        Strategy<T, R> strategy = Optional.ofNullable(strategyMap).orElseThrow(() -> new RuntimeException("The strategy pool is empty!")).get(strategyKey);

        return Optional.ofNullable(strategy).orElseThrow(() -> new RuntimeException("No strategy found!")).execute(param);

    }


    @Override
    public void afterPropertiesSet() throws Exception {

        if(! CollectionUtils.isEmpty( strategyList)){
            strategyMap = strategyList.stream().collect(Collectors.toMap(Strategy::strategyKey, Function.identity()));
        }

    }
}
