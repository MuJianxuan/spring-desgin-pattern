package org.designpattern.spring.decorator.non;

import org.designpattern.spring.decorator.MilkTeaOperator;
import org.designpattern.spring.decorator.MilkTea;

/**
 * 珍珠奶茶
 * @author Rao
 * @Date 2021-11-02
 **/
public class MilkTeaPearlOperator extends MilkTeaOperator {

    @Override
    public void decorate(MilkTea milkTea) {

        // 贵两元
        milkTea.setPrice( milkTea.getPrice() + 2);
        // 添加属性信息
        milkTea.setName("Pear " + milkTea.getName());

    }
}
