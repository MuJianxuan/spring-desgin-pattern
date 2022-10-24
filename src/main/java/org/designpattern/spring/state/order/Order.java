package org.designpattern.spring.state.order;

import lombok.Data;
import lombok.experimental.Accessors;
import org.designpattern.spring.state.v2.StateMachineId;

import java.io.Serializable;

/**
 * @author Rao
 * @Date 2021-10-23
 **/
@Data
@Accessors(chain = true)
public class Order implements Serializable, StateMachineId {

    /**
     * 订单Id
     */
    private Long id;

    /**
     * 价格
     */
    private Integer price;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 状态 0-待支付 1-待发货
     */
    private Integer orderStatus;

    @Override
    public Serializable stateMachineId() {
        return id;
    }
}
