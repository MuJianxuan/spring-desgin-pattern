package org.designpattern.spring.creationtype.factory;

/**
 * @author Rao
 * @Date 2021/11/03
 **/
public interface StrFactory {

    /**
     * String 理解成 一种产品  >> eg Product --> ProductA ProductB
     * @return
     */
    String createStr();

}
