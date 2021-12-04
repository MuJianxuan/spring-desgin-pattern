package org.designpattern.spring.creationtype.factorymethod;

/**
 * @author Rao
 * @Date 2021/11/03
 **/
public class Str1Factory implements StrFactory{
    @Override
    public String createStr() {
        return "1";
    }
}
