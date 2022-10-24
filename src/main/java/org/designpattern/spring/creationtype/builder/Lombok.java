package org.designpattern.spring.creationtype.builder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * desc: lombok注解
 *
 * @author create 2022/7/14 by rao
 */
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Lombok {

    /**
     * 构建
     */
    private String key;

}
