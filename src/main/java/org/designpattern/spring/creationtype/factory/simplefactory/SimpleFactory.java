package org.designpattern.spring.creationtype.factory.simplefactory;

/**
 * @author Rao
 * @Date 2021/12/25
 **/
public class SimpleFactory {

    /**
     * 工厂仅提供创建对象的方法，  对象对象！万物都是对象，工厂常和策略模式 结合一起使用，每一种策略，怎么知道使用哪种？由工厂写好的逻辑提供。
     *
     * 创建对象
     * @param type
     * @return
     */
    public static String createString(int type){

        // case A ----> ProductA
        // case B ----> ProductB

        return type == 1 ? "1" : "2";
    }
}
