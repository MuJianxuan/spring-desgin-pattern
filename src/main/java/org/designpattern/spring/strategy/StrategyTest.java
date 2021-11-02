package org.designpattern.spring.strategy;

import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author Rao
 * @Date 2021-10-18
 **/
public class StrategyTest {

    private static Map<String, HelloStrategy> strategyContext;

    static {
        // 这一步的目的是 在Spring中可以联想到注入方式，更理解业务策略如何管理的目的
        strategyContext = Stream.of(new HelloWordStrategyImpl(), new HelloYouStrategyImpl()).collect(Collectors.toMap(HelloStrategy::name, Function.identity()));
    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (true){
            String line = scanner.nextLine();
            if( "".equals(line)){
                break;
            }
            HelloStrategy helloStrategy = strategyContext.get(line);
            if( helloStrategy == null){
                break;
            }
            helloStrategy.execute();

        }
        scanner.close();

    }

}
