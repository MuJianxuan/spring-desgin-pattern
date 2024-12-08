package org.designpattern.spring.responsibilitychain.core;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.AnnotationAwareOrderComparator;
import org.springframework.util.CollectionUtils;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * 重构设计
 * @author Rao
 * @Date 2021-11-01
 **/
@Slf4j
public class ResponsibilityChain<T> implements Chain<T> {

    private final List<ChainNode<T>> chainNodeList;

    /**
     * 主节点
     */
    private ChainNode<T> mainNode;

    public ResponsibilityChain(List<ChainNode<T>> chainNodeList) {
        this.chainNodeList = chainNodeList;
        this.init();
    }

    @Override
    public void execute(T param) {
        Optional.ofNullable(mainNode).ifPresent( mainNode -> mainNode.execute( param));
    }

    /**
     * order  基于注解的order排序 {@link AnnotationAwareOrderComparator#sort}
     */
    private void init()  {

        log.info("xxx");
        // 获取
        if (! CollectionUtils.isEmpty( chainNodeList)){

            chainNodeList.sort( Comparator.comparingInt(ChainNode::order));
            chainNodeList.forEach( chainNode -> {

                if( this.mainNode == null){
                    this.setMainNode( chainNode);
                }
                // 责任链构建
                else {
                    this.mainNode.buildFinallyChainNode( (AbstractChainNode<T>) chainNode);
                }

            });

        }

    }

    /**
     * 设置 主节点
     * @param mainNode
     */
    private void setMainNode(ChainNode<T> mainNode) {
        this.mainNode = mainNode;
    }


}
