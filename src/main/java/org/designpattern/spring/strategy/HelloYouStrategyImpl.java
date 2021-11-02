package org.designpattern.spring.strategy;

/**
 * @author Rao
 * @Date 2021-10-18
 **/
public class HelloYouStrategyImpl implements HelloStrategy {
    @Override
    public String name() {
        return "2";
    }

    @Override
    public void execute() {
        System.out.println("HelloYouStrategyImpl");
    }
}
