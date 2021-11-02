package org.designpattern.spring;

import org.designpattern.spring.state.core.StateOperator;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * 解析 注解信息
 * @author Rao
 * @Date 2021-11-02
 **/
//@Component
public class CustomBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        // 解析Bean
        Class<?> aClass = bean.getClass();
        //
        if (aClass.isAnnotationPresent(StateOperator.class)) {
            StateOperator stateOperator = aClass.getAnnotation(StateOperator.class);
            // 获取数据信息
            String business = stateOperator.business();



        }

        return bean;
    }
}
