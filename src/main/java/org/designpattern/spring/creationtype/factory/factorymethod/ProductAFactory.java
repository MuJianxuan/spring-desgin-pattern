package org.designpattern.spring.creationtype.factory.factorymethod;

import org.designpattern.spring.creationtype.factory.product.Product;
import org.designpattern.spring.creationtype.factory.product.ProductA;
import org.designpattern.spring.creationtype.factory.product.ProductFactory;

/**
 * @author Rao
 * @Date 2021/12/25
 **/
public class ProductAFactory implements ProductFactory {
    @Override
    public Product createProduct() {
        return new ProductA();
    }
}
