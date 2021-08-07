package org.designpattern.spring.responsibilitychain.handle;

import org.designpattern.spring.responsibilitychain.Handler;
import org.designpattern.spring.responsibilitychain.ResponsibilityChain;

/**
 * @author Rao
 * @Date 2021/8/1
 **/
public class BHandler extends ResponsibilityChain {
    @Override
    public void handle() {
        System.out.println("B handler ...........");
    }

    @Override
    public boolean isSupport() {
        return true;
    }
}
