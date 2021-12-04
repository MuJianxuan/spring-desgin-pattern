package org.designpattern.spring.decorator.example;

import org.designpattern.spring.decorator.MilkTea;

/**
 * @author Rao
 * @Date 2021-11-02
 **/
public class Pearl implements DrinkAbstract {

    private DrinkAbstract drinkAbstract;

    public Pearl(DrinkAbstract drinkAbstract) {
        this.drinkAbstract = drinkAbstract;
    }

    @Override
    public void plusAdditionVal() {
        // 如果是奶茶
        if(drinkAbstract instanceof MilkTea){
            MilkTea drinkAbstract = (MilkTea) this.drinkAbstract;
            drinkAbstract.setName(drinkAbstract.getName() + " -- " + "pearl");
            drinkAbstract.setPrice(drinkAbstract.getPrice() + 55);

            drinkAbstract.plusAdditionVal();
        }
    }
}
