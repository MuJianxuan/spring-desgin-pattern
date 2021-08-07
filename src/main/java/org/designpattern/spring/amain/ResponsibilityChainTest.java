package org.designpattern.spring.amain;

import org.designpattern.spring.responsibilitychain.handle.AHandler;
import org.designpattern.spring.responsibilitychain.handle.BHandler;
import org.designpattern.spring.responsibilitychain.handle.CHandler;

/**
 * @author Rao
 * @Date 2021/8/1
 **/
public class ResponsibilityChainTest {
    public static void main(String[] args) {

        AHandler aHandler = new AHandler();
        aHandler.setNextChain( new BHandler());
        aHandler.setNextChain( new CHandler());

        aHandler.doHandle();

    }
}
