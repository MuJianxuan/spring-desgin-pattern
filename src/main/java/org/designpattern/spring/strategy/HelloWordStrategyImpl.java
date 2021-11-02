package org.designpattern.spring.strategy;

/**
 * @author Rao
 * @Date 2021-10-18
 **/
public class HelloWordStrategyImpl implements HelloStrategy {
    @Override
    public String name() {
        return "1";
    }

    @Override
    public void execute() {
        System.out.println("HelloWordStrategyImpl");
    }
}
