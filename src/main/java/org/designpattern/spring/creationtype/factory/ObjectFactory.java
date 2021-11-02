package org.designpattern.spring.creationtype.factory;

/**
 * 创建型
 * 对象工厂
 * @author Rao
 * @Date 2021-10-21
 **/
public class ObjectFactory {

    /**
     * 工厂仅提供创建对象的方法，  对象对象！万物都是对象，工厂常和策略模式 结合一起使用，每一种策略，怎么知道使用哪种？由工厂写好的逻辑提供。
     * 创建对象
     * @param type
     * @return
     */
    public String createString(int type){
        return type == 1 ? "1" : "2";
    }



}
