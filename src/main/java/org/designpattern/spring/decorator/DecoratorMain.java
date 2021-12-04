package org.designpattern.spring.decorator;

import org.designpattern.spring.decorator.example.Pearl;
import org.designpattern.spring.decorator.non.MilkTeaCoconutOperator;
import org.designpattern.spring.decorator.non.MilkTeaPearlOperator;

/**
 * 装饰者设计模式:  装饰器模式，顾名思义，就是对已经存在的某些类进行装饰，以此来扩展一些功能。
 *               就是将某个类重新装扮下，使它在功能上更强大，但是作为原来的这个类，使用者不应该感受到装饰前与装饰后有什么不同，
 *               否则就破坏了原有类的结构，所以装饰器模式要做到对装饰类的使用者透明。
 *   识别主体：
 *   1、被装饰对象
 *   2、装饰物
 *   3、装饰入口
 *   4、查看结果
 *   5、装饰类型（interface）装饰的都是同类的
 * > 装饰的类型是确定的
 *
 * 业务思考
 *    1、
 * @author Rao
 * @Date 2021-11-02
 **/
public class DecoratorMain {
    public static void main(String[] args) {

        // 不使用 装饰者设计模式
        MilkTea milkTea = new MilkTea("milk tea", 10);
        // 加珍珠
        new MilkTeaPearlOperator().decorate(milkTea);
        // 加椰果
        new MilkTeaCoconutOperator().decorate(milkTea);

        // 这种很类似 流水先代码，需要对其进行优化设计

        System.out.println(milkTea);


        //我觉得 例子上的还是有点点问题的
        Pearl pearl = new Pearl( milkTea);
        // 添加珍珠
        pearl.plusAdditionVal();


        // 分析 Jdk InputStream 流的整体结构，首先其设计上是非单例的； 这点说明可以运用到 我们的业务中，但容易把结构弄得复杂
        // 我目前还不确认 业务上可以使用当前设计模式的地方，等遇到了我再补充。

        // 我看了很多设计 ，简单的 装饰者模式 其实很类似代理模式的，但是 我更认为 装饰者模式的设计思想在于一个整体的结构上。
        // 关于 适配器模式和 装饰模式上的不同，首先需要明白的 是 一个是提供适配行为，一个是提供 功能的接口，适配的行为是一个功能 也可以说得过去；
        //所以这个设计模式是很重复得概念的。 此外，我有看到 对适配器模式和装饰模式有一个定义叫：包装模式，我认为是很贴切的，对一个传输的对象包装，可能可以和 建造者模式结合起来使用。

        // 适配器模式的 运用场景不是很多，有点把代码变得复杂化了。



    }
}
