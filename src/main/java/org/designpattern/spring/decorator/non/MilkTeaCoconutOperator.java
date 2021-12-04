package org.designpattern.spring.decorator.non;

import org.designpattern.spring.decorator.MilkTea;
import org.designpattern.spring.decorator.MilkTeaOperator;

/**
 * 椰果
 * @author Rao
 * @Date 2021-11-02
 **/
public class MilkTeaCoconutOperator extends MilkTeaOperator {
    @Override
    public void decorate(MilkTea milkTea) {
        milkTea.setName("Coconut " + milkTea.getName());
        milkTea.setPrice( milkTea.getPrice() + 2);
    }
}
