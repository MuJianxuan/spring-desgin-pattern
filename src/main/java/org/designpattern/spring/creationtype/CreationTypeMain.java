package org.designpattern.spring.creationtype;

import org.designpattern.spring.creationtype.builder.Key;
import org.designpattern.spring.creationtype.factory.StrFactory;
import org.designpattern.spring.creationtype.factory.factorymethod.Str1Factory;
import org.designpattern.spring.creationtype.factory.simplefactory.SimpleFactory;
import org.designpattern.spring.creationtype.prototype.Prototype;
import org.designpattern.spring.creationtype.singleton.SingleEnum;

/**
 * 创建型设计模式 ：
 * 1、工厂方法
 *       思考问题： 创建对象为什么需要工厂类呢？  我认为，是对代码复用的一种聚合，把创建不同对象的逻辑进行收拢，也是把功能聚合。
 * 2、抽象工厂
 *      工厂通常不是单独使用的，会与多个设计模式一起使用，使得当前设计模式的使用更有意义。 创建 工厂的工厂。需要明白的是 工厂亦是对象，没有什么不同。
 *      主要解决 接口选择的问题，
 * 3、建造者
 * 4、原型  
 * 5、单例  仅推荐两种  一个内部静态类 一种是 枚举单例。
 * @author Rao
 * @Date 2021/11/03
 **/
public class CreationTypeMain {

    public static void main(String[] args) throws CloneNotSupportedException {

        // 简单工厂方法
        String str = SimpleFactory.createString(1);
        System.out.println( str);

        // 工厂方法
        StrFactory factory = new Str1Factory();
        System.out.println( factory.createStr());

        // 建造者
        Key create = Key.KeyBuilder.builder().business("1").initState("2").nextState("3").triggerEvent("create").build();
        System.out.println( create);

        // 原型模式
        Prototype prototypeOld = new Prototype();
        Prototype clone = (Prototype) prototypeOld.clone();
        System.out.println( prototypeOld == clone);

        // 单例
        System.out.println( SingleEnum.getInstance() == SingleEnum.getInstance());

    }

}
