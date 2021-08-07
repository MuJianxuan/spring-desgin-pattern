package org.designpattern.spring.responsibilitychain.handle;

import org.designpattern.spring.responsibilitychain.ResponsibilityChain;

/**
 * @author Rao
 * @Date 2021/8/1
 **/
public class AHandler extends ResponsibilityChain {
    @Override
    public void handle() {
        System.out.println("A Handle .........");
    }

    @Override
    public boolean isSupport() {
        return true;
    }
}
