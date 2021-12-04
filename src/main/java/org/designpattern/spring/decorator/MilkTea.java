package org.designpattern.spring.decorator;

import lombok.Data;
import org.designpattern.spring.decorator.example.DrinkAbstract;

/**
 * 被装饰对象
 * 奶茶
 * @author Rao
 * @Date 2021-11-02
 **/
@Data
public class MilkTea implements DrinkAbstract {

    /**
     * 名称
     */
    private String name;

    /**
     * 价格
     */
    private int price;

    public MilkTea(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return name + ",price:" + price ;
    }

    @Override
    public void plusAdditionVal() {
        System.out.println("name = "+ name  + " price = " + price);
    }
}
