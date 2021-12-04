package org.designpattern.spring.creationtype.singleton;

import org.designpattern.spring.Param;

/**
 * @author Rao
 * @Date 2021/11/03
 **/
public enum SingleEnum {

    /**
     * 枚举单例
     */
    SINGLETON;

    private final Param param;

    SingleEnum() {
        param = new Param();
    }

    public static Param getInstance(){
        return SINGLETON.param;
    }

}
