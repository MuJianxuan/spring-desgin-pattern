package org.designpattern.spring.responsibilitychain;

import org.designpattern.spring.Param;
import org.designpattern.spring.responsibilitychain.core.AbstractChainNode;
import org.springframework.stereotype.Service;

/**
 * @author Rao
 * @Date 2021-11-01
 **/
@Service
public class CheckParam2ResponsibilityChainNode extends AbstractChainNode<Param> {
    @Override
    protected void handle(Param param) {
        System.out.println("CheckParam2ResponsibilityChainNode............");
    }

    @Override
    public boolean support(Param param) {
        return false;
    }
}
