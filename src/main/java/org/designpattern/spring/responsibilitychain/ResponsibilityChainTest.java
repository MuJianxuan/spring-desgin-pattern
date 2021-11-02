package org.designpattern.spring.responsibilitychain;

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

        // 1、选择业务下的链
        // 如何构建业务链  order 排序?
        // 借助Spring的自动注入，然后将 业务链 是 可 持续的 or 还是 不可持续？




    }
}
