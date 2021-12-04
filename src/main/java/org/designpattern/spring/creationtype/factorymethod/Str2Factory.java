package org.designpattern.spring.creationtype.factorymethod;

/**
 * @author Rao
 * @Date 2021/11/03
 **/
public class Str2Factory implements StrFactory {
    @Override
    public String createStr() {
        return "2";
    }
}
