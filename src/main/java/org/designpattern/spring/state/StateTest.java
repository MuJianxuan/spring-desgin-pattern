package org.designpattern.spring.state;

import com.alibaba.fastjson.JSON;
import org.designpattern.spring.state.core.*;
import org.designpattern.spring.state.order.*;
import org.designpattern.spring.state.order.StateMachine;

/**
 * 状态模式有点像策略模式
 *
 * 状态机
 *
 * @author Rao
 * @Date 2021-10-20
 **/
public class StateTest {

    private static ChannelState state = new AvailableState();

    public static void study() throws Exception{
        /**
         * 状态设计模式：
         *  1、状态可以是类 ，也可以是某个属性，面向对象开发，属性看作是一个对象也没什么不同；
         *  2、状态设计模式的要点在于 对状态变化的过程（或 处于不同的状态）可以选择不同的执行，我认为这一点和策略模式是有类似的。
         *  业务中免不了不同状态做不同处理的代码，简单情况下我们只需要用if-else,switch-case就可以实现。以下情况，请考虑使用状态机模式。
         *  3、状态模式 的核心点是 对象处于何种状态下的行为会发生什么变化
         *  （不一定就发生变化，有可能不变，所以会出现空实现，这个时候可以定义父类来控制，比如我多种状态下的操作是一样的）
         *  4、状态设计模式应用场景，我觉得在设计上可以考虑一种 全局的状态标识，比如 第三方渠道状态，
         *  比如一篇文章的状态，在分布式系统中，如果一个人已经将文章处于编辑状态了，那么其他人尝试编辑则无法打开，因此这个时候就可以考虑使用状态模式来扩展，
         *  在使用 设计模式 应用时， 也不必过分使用，有一些 if 可以简略的是可以使用的，重要是理解设计模式主要是做扩展的，我认为使用设计模式考虑的点是，
         *  在这个场景实现时，能去猜想会不会出现其他实现，固定的格式是不必要使用设计模式来使得代码变得多了。
         *
         *  状态要考虑 是个全局状态值 ，是大家所认知的。 这点很重要。
         *
         */

        // 目前状态
        new Thread(() -> {
            try {
                Thread.sleep(600);
                // 状态变了
                state = new UnavailableState();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        // 模拟有请求在执行
        int count = 5;
        while (count-- > 0){

            state.createPrepaidOrder();
            Thread.sleep(200);

        }
    }

    public static void stateMachine() throws Exception{

        // 这里和想法有出入， 如何让事件和 业务绑定是 聚合的一种想法
        // 利用接口的特性 提供 这么一套功能
        // 目前这里 有一个问题 是 注解处无法使用 枚举的值 ，这就导致 处理不是很方便，要么使用 类对枚举进行区分，如 State.class
        String key = StateKeyBuilder.builder()
                .business(BusinessStateMachineEnum.order.name())
                .triggerEvent(OrderStateEventEnum.create_event.name())
                .initState( StateContents.NO_STATUS )
                .nextState(OrderStateEnum.wait_pay.name())
                .build();

        System.out.println(key);

        StateContext<Order> stateContext = new StateContext<>();
        stateContext.setKey( key);
        StateResult<Order> result = StateMachine.handle(stateContext);
        System.out.println( "result: " + JSON.toJSONString( result));


    }

    public static void main(String[] args) throws Exception {
        // TODO 这里设计有问题

        /**
         * 状态模式实现一个状态机，状态模式将每一个状态封装成独立的类，
         * 具体行为会随着内部状态而改变。状态模式用类表示状态，这样我们就能通过切换类来方便地改变对象的状态，避免了冗长的条件分支语句
         *
         *
         * 🍃【SpringBoot技术专题】「StateMachine」FSM状态机设计及实现
         * 原文链接： https://xie.infoq.cn/article/ffc60200da80e7ad79acd6678
         */

        /**
         * 我认为 状态机是 状态机，与状态模式 是不同的，状态模式 侧重与 对象内在的状态
         * 而状态机则是关注 状态因什么事件扭转什么状态后发生行为并更新状态。
         * 补充 ： 状态机每一个实例都应该是独立的，有自己的主要扭转，那么就有状态机的初始以及状态机的动作方式，自动还是手动
         * 通过对Spring machine 的了解后，对状态机的概念以及设想更加的具体，状态机是一个 对象实例，与订单是同一个东东，一个订单就应该对应一个状态机
         *
         */
        // 简单的状态模式  >> 当一个对象的内在状态改变时允许改变其行为，这个对象看起来像是改变了其类。
        // 状态机模式

        stateMachine();

    }
}
