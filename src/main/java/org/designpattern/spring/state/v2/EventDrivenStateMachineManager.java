package org.designpattern.spring.state.v2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.ResolvableType;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 业务 注入 bean
 * @author create 2022/7/18 by rao
 */
@Slf4j
@Component
public class EventDrivenStateMachineManager implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @SuppressWarnings("unchecked")
     public <T extends StateMachineId> EventDrivenStateMachine<T> create(){
         String[] stateAssistantBeanNames = applicationContext.getBeanNamesForType(ResolvableType.forType(new ParameterizedTypeReference<AbstractStateAssistant<T>>() {
         }));
         if(stateAssistantBeanNames.length != 1){
             throw new RuntimeException("stateAssistant require one,but found " + stateAssistantBeanNames.length);
         }
         AbstractStateAssistant<T> stateAssistant = (AbstractStateAssistant<T>) applicationContext.getBean(stateAssistantBeanNames[0]);

        ObjectProvider<AbstractEventBehaviorHandler<T>> beanProvider = applicationContext.getAutowireCapableBeanFactory().getBeanProvider(ResolvableType.forType(new ParameterizedTypeReference<AbstractEventBehaviorHandler<T>>() {
        }));
        List<AbstractEventBehaviorHandler<T>>  eventBehaviorHandlerList = beanProvider.stream().filter(eventBehaviorHandler -> Objects.nonNull(eventBehaviorHandler.drivenEvent())).collect(Collectors.toList());
        Map<DrivenEvent, AbstractEventBehaviorHandler<T>> eventBehaviorHandlerPool = eventBehaviorHandlerList.stream().collect(Collectors.toMap(AbstractEventBehaviorHandler::drivenEvent, Function.identity()));
        return new EventDrivenStateMachine<>(stateAssistant, eventBehaviorHandlerPool);
     }

    @Override
    public void setApplicationContext(@Nullable ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
