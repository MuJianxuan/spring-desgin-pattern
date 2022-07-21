package org.designpattern.spring.strategy.core;

import java.util.Map;
import java.util.Optional;

/**
 * 定义池的时候需要带上 业务标识（Business identity）
 * @author Rao
 * @Date 2021-11-01
 **/
public class StrategyPool<T extends StrategyKey> {
    private final Map<String, Strategy<T>> strategyMap;

    public StrategyPool(Map<String, Strategy<T>> strategyMap) {
        this.strategyMap = strategyMap;
    }

    /**
     * 执行业务
     * @param param
     */
    public void execute(T param){
        Strategy<T> strategy = Optional.ofNullable(strategyMap).orElseThrow(() -> new RuntimeException("The strategy pool is empty!")).get(param.strategyKey());
        Optional.ofNullable(strategy).orElseThrow(() -> new RuntimeException("No strategy found!")).execute(param);
    }
}
