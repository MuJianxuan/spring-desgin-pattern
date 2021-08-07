package org.designpattern.spring.responsibilitychain;

/**
 * Handler
 * @author Rao
 * @Date 2021/8/1
 **/
public interface Handler {

    void handle();

    boolean isSupport();

}
