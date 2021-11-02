package org.designpattern.spring.responsibilitychain;

import org.designpattern.spring.Param;
import org.designpattern.spring.responsibilitychain.core.AbstractResponsibilityChain;
import org.designpattern.spring.responsibilitychain.core.ResponsibilityChain;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Rao
 * @Date 2021-11-01
 **/
@Configuration
public class ResponsibilityChainConfiguration {

    @Bean
    public ResponsibilityChain<Param> orderResponsibilityChain(){
        return new AbstractResponsibilityChain<Param>() {};
    }

}
