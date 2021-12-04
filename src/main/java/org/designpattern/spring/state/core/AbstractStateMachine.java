package org.designpattern.spring.state.core;

import org.designpattern.spring.state.order.Order;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 基于Spring的设计  若需要支持其他容器 可以再往上 抽象一层
 * 1、抽象状态机
 * 2、管理业务状态的扭转行为 和 相关状态
 * @author Rao
 * @Date 2021-10-26
 **/
public abstract class AbstractStateMachine<T,R> implements InitializingBean {

    private Map<String, AbstractStateOperator<T,R>> stateOperatorMap;

    @Resource
    private List<AbstractStateOperator<T,R>> stateOperatorList;

    @Override
    public void afterPropertiesSet() throws Exception {
        if( ! CollectionUtils.isEmpty( stateOperatorList)){
            // 从一个地方能获取到对应的key都可以的
            stateOperatorMap = stateOperatorList.stream().collect(Collectors.toMap(AbstractStateOperator::operateKey, Function.identity()));
        }
    }

    /**
     * 调用业务
     */
    public StateResult<R> execute(StateContext<T> stateContext){
        return Optional.ofNullable( stateOperatorMap).map(map -> map.get(stateContext.getKey())).orElseThrow(() -> new RuntimeException("No implementation found!"))
                // 核心逻辑
                .handle(stateContext);
    }

}