package org.designpattern.spring.state.simplestate;

/**
 * 状态
 *
 * @author Rao
 * @Date 2022/10/24
 **/
public interface State<P,R> {

    /**
     * 执行操作
     * @param param
     * @return
     */
    R doAction(P param);

    /**
     * 空执行
     * @param param
     */
    default void execute(P param){
        this.doAction(param);
    }

}
