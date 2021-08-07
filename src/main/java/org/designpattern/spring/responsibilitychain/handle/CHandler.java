package org.designpattern.spring.responsibilitychain.handle;

import org.designpattern.spring.responsibilitychain.ResponsibilityChain;

/**
 * @author Rao
 * @Date 2021/8/1
 **/
public class CHandler extends ResponsibilityChain {
    @Override
    public void handle() {
        System.out.println("C handler...........");
    }

    @Override
    public boolean isSupport() {
        return true;
    }
}
