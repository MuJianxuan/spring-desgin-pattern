package org.designpattern.spring.state.core;

import org.springframework.stereotype.Service;

import java.lang.annotation.*;

/**
 * @author Rao
 * @Date 2021-10-25
 **/
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Service
@Deprecated
public @interface StateOperator {

    /**
     * 业务
     * @return
     */
    String business();

    /**
     * 事件
     * @return
     */
    String triggerEvent() default "";

    /**
     * 初始状态
     * @return
     */
    String initState() default "";

    /**
     * 下一状态
     * @return
     */
    String nextState() default "";

}
