package org.designpattern.spring.state.v2;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

/**
 * desc:
 * 1、注入到Spring中
 * 2、创建  会读取当前状态  依据事件+当前状态获取
 *
 *      状态扭转机注册器 （State Torsion machine Register）
 *      状态扭转机（State Torsion machine）
 *      状态持久人（State Assistant）
 *      状态枚举 （StateEnum）
 *      事件枚举  （EventEnum）
 *      事件行为处理 （Event behavior Handler）
 *
 *
 * 3、状态 ->
 *
 * @author Rao
 * @Date 2022/06/23
 **/
public class StateM {

    private static Map<String, Consumer<String>> consumerMap = new HashMap<>();

    public static void main(String[] args) {

        Consumer<String> xx = consumerMap.get("xx");
        xx.accept( "dd" );


    }



}
