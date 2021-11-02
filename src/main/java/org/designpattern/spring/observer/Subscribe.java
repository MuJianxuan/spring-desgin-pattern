package org.designpattern.spring.observer;

import org.springframework.context.ApplicationEvent;

/**
 * @author Rao
 * @Date 2021-11-02
 **/

public interface Subscribe {

    /**
     * ID
     * @return
     */
    int id();

    /**
     * 设置ID
     * @return
     */
    void setId(int id);

    /**
     * 通知执行
     */
    void notifyExecute(ApplicationEvent event);

}
